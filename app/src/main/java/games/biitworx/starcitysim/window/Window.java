package games.biitworx.starcitysim.window;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Menu;

import games.biitworx.starcitysim.Fonts;
import games.biitworx.starcitysim.MenuRects;

/**
 * Created by marce_000 on 21.04.2016.
 */
public abstract class Window {

    private int scrollPosition = 0;
    private String text = "";
    private Contents contents = new Contents();

    public Window(String text) {

        this.text = text;
    }

    public int getScrollPosition(){
        return scrollPosition;
    }

    public void setScrollPosition(int scrollPosition) {
        this.scrollPosition = scrollPosition;
    }

    public int getMaxScrollPosition(){
        return contents.getMaxLine()*MenuRects.line.get().height();
    }

    public void onDraw(Canvas canvas) {
        Rect bounds = MenuRects.contentInner.get();

        Bitmap outerContent = Bitmap.createBitmap(bounds.right, bounds.height(), Bitmap.Config.ARGB_4444);

        Canvas canvasOuterContent = new Canvas(outerContent);

        contents.onDraw(canvasOuterContent,scrollPosition);

        canvas.drawBitmap(outerContent, bounds.left, bounds.top, null);


        Rect base = MenuRects.info.get();
        Fonts.FONT.setTextSize((base.height() / 4));


        canvas.drawText(text, base.centerX()-(text.length()/2)*Fonts.FONT.getTextSize(), base.centerY(), Fonts.FONT);
    }

    public Contents getContents() {
        return contents;
    }

    public void checkHit(int x,int y){
        for(Content c : contents.getItems()){
            if(c.hasAction()&&c.isHit(x,y)){
                c.getAction().run();
            }
        }
    }

}
