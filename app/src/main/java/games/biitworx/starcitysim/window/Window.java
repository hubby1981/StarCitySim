package games.biitworx.starcitysim.window;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.Menu;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.BitmapDrawer;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Fonts;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.MenuRects;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.window.content.Content;

/**
 * Created by marce_000 on 21.04.2016.
 */
public abstract class Window {

    private int scrollPosition = 0;
    private String text = "";
    private String hint = "";


    private Contents contents = new Contents();
    public boolean scroller = false;
    public boolean down = true;

    public Window(String text) {
        this(text, "");
    }

    public Window(String text, String hint) {
        this.text = text;
        this.hint = hint;
    }

    private String getHint(){
        return hint;
    }

    public int getScrollPosition() {
        return scrollPosition;
    }

    public void setScrollPosition(int scrollPosition) {
        this.scrollPosition = scrollPosition;
    }

    public int getMaxScrollPosition() {
        return contents.getMaxLine() * (MenuRects.line.get().height());
    }

    public void onDraw(Canvas canvas) {
        Rect bounds = MenuRects.contentInner.get();

        Bitmap outerContent = Bitmap.createBitmap(bounds.right, bounds.height(), Bitmap.Config.ARGB_4444);

        Canvas canvasOuterContent = new Canvas(outerContent);

        contents.onDraw(canvasOuterContent, scrollPosition);

        canvas.drawBitmap(outerContent, bounds.left, bounds.top, null);


        Rect base = MenuRects.info.get();
        Fonts.FONT.setTextSize((base.height() / 7));
        String time = Game.YEAR + "" + Game.MONTH + "." + Game.DAY;
        canvas.drawText(time, base.centerX() - (Fonts.FONT.getTextSize() * time.length() / 3), (int) (base.centerY() - Fonts.FONT.getTextSize() ), Fonts.FONT);
        Fonts.FONT.setTextSize((base.height() / 4));

        canvas.drawText(text, base.centerX() - (Fonts.FONT.getTextSize() * text.length() / 2), base.centerY() + (int) (Fonts.FONT.getTextSize() * 1.5), Fonts.FONT);


        if(MenuRects.notification!=null && MenuRects.notification.get()!=null && getHint().length()>0){
            Rect base2 = MenuRects.notification.get();
            Fonts.FONT.setTextSize((base.height() / 8));

            canvas.drawText(hint, base2.centerX()-(int)((Fonts.FONT.getTextSize()*hint.length())/2), (int) (base2.top + Fonts.FONT.getTextSize() *1.5), Fonts.FONT);

        }

        int w = MenuRects.content.get().right - bounds.right;
        int w2 = w / 10;
        if (scroller && down) {

            Bitmap b = B.get(R.drawable.down);
            Rect rc = new Rect((MenuRects.content.get().right - w) - w2, (MenuRects.contentInner.get().bottom - w) - w2, (MenuRects.content.get().right) - w2, MenuRects.contentInner.get().bottom - w2);
            BitmapDrawer.drawImage(b, canvas, rc, null, true);

        }
        if (scroller && scrollPosition > 20) {
            Bitmap b = B.get(R.drawable.up);

            Rect rc = new Rect((MenuRects.content.get().right - w) - w2, MenuRects.contentInner.get().top + w2, (MenuRects.content.get().right) - w2, (MenuRects.contentInner.get().top + w) + w2);
            BitmapDrawer.drawImage(b, canvas, rc, null, true);
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
