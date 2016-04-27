package games.biitworx.starcitysim.window;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.BitmapDrawer;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Fonts;
import games.biitworx.starcitysim.MenuRects;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.window.content.Content;

/**
 * Created by marce_000 on 21.04.2016.
 */
public abstract class Window {

    private int scrollPosition = 0;
    private String text = "";
    private Contents contents = new Contents();
    public boolean scroller = false;
    public boolean down = true;

    public Window(String text) {

        this.text = text;
    }

    public int getScrollPosition() {
        return scrollPosition;
    }

    public void setScrollPosition(int scrollPosition) {
        this.scrollPosition = scrollPosition;
    }

    public int getMaxScrollPosition() {
        return contents.getMaxLine() * MenuRects.line.get().height();
    }

    public void onDraw(Canvas canvas) {
        Rect bounds = MenuRects.contentInner.get();

        Bitmap outerContent = Bitmap.createBitmap(bounds.right, bounds.height(), Bitmap.Config.ARGB_4444);

        Canvas canvasOuterContent = new Canvas(outerContent);

        contents.onDraw(canvasOuterContent, scrollPosition);

        canvas.drawBitmap(outerContent, bounds.left, bounds.top, null);


        Rect base = MenuRects.info.get();
        Fonts.FONT.setTextSize((base.height() / 4));


        canvas.drawText(text, base.left+base.width()/20, base.centerY()-Fonts.FONT.getTextSize()/2, Fonts.FONT);
int w2=5;
        if (scroller && down) {

            Bitmap b = B.get(R.drawable.down);
            int w =25;
            Rect rc = new Rect(bounds.right-w2 , bounds.bottom - w, (bounds.right+w)-w2, bounds.bottom);
            BitmapDrawer.drawImage(b, canvas, rc, null,true);

        }
        if(scroller && scrollPosition>20){
            Bitmap b = B.get(R.drawable.up);
            int w =25;
            Rect rc = new Rect(bounds.right-w2, bounds.top , (bounds.right+w)-w2, bounds.top+w);
            BitmapDrawer.drawImage(b, canvas, rc, null,true);
        }
    }

    public Contents getContents() {
        return contents;
    }

    public void checkHit(int x, int y) {
        for (Content c : contents.getItems()) {
            if (c.hasAction() && c.isHit(x, y)) {
                c.getAction().run();
            }
        }
    }

}
