package games.biitworx.starcitysim.window;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.window.content.Content;

/**
 * Created by marce_000 on 21.04.2016.
 */
public abstract class Window {

    private int scrollPosition = 0;
    private String text = "";
    private String hint = "";
    private Window overlayWindow;

    private Contents contents = new Contents();
    public boolean scroller = false;
    public boolean down = true;
    public Bitmap old = null;

    public Window(String text) {
        this(text, "");
    }

    public Window(String text, String hint) {
        this.text = text;
        this.hint = hint;
    }

    public void setOverlayWindow(Window overlayWindow) {
        this.overlayWindow = overlayWindow;
    }

    public Window getOverlayWindow() {
        return overlayWindow;
    }

    private String getHint() {
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

    public void free() {
        old = null;
    }

    public void onDraw(Canvas canvas, boolean sc) {

        Game.LOCKED = true;
        Rect bounds = MenuRects.contentInner.get();


        old = Bitmap.createBitmap(bounds.right, bounds.height(), Bitmap.Config.ARGB_8888);

        Canvas canvasOuterContent = new Canvas(old);

        contents.onDraw(canvasOuterContent, scrollPosition);


        canvas.drawBitmap(old, bounds.left, bounds.top, null);
        Rect base = MenuRects.info.get();
        Fonts.FONT.setTextSize((base.height() / 5));
        String time = Game.YEAR + "." + Game.MONTH + "." + Game.DAY + "." + Game.COUNT;
        float size = Fonts.FONT.measureText(time);
        canvas.drawText(time, base.centerX() - size / 2, (int) (base.centerY() - Fonts.FONT.getTextSize()), Fonts.FONT);

        Fonts.FONT.setTextSize((base.height() / 3));
        size = Fonts.FONT.measureText(text);


        canvas.drawText(text, base.centerX() - size / 2, base.centerY() + (int) (Fonts.FONT.getTextSize() * 1.15), Fonts.FONT);


        String hint = getHint();
        if (hint.length() == 0)
            hint = T.get(R.string.overlay_hint);
        if (MenuRects.notification != null && MenuRects.notification.get() != null && hint.length() > 0 && sc) {
            Rect base2 = MenuRects.notification.get();
            Fonts.FONT.setTextSize((base.height() / 6));
            size = Fonts.FONT.measureText(hint);
            canvas.drawText(hint, base2.centerX() - size / 2, (int) (base2.top + Fonts.FONT.getTextSize() * 1), Fonts.FONT);

        }
        if (sc) {
            int w = MenuRects.content.get().right - bounds.right;
            int w2 = w / 10;
            if (scroller && down) {

                Bitmap b = B.get(R.drawable.down);
                Rect rc = new Rect((MenuRects.content.get().right - w) - w2, (MenuRects.contentInner.get().bottom - w) - w2, (MenuRects.content.get().right) - w2, MenuRects.contentInner.get().bottom - w2);
                BitmapDrawer.drawImage(b, canvas, rc, null, true);

            }
            if (scroller && scrollPosition > 0) {
                Bitmap b = B.get(R.drawable.up);

                Rect rc = new Rect((MenuRects.content.get().right - w) - w2, MenuRects.contentInner.get().top + w2, (MenuRects.content.get().right) - w2, (MenuRects.contentInner.get().top + w) + w2);
                BitmapDrawer.drawImage(b, canvas, rc, null, true);
            }
        }

        Game.LOCKED = false;

    }

    public Contents getContents() {
        return contents;
    }

    public boolean checkHit(int x, int y) {
        boolean ret = false;
        for (Content c : contents.getItems()) {
            if (c.hasAction() && c.isHit(x, y)) {
                c.getAction().run();
                c.wasHit = true;
                ret = true;
            } else {
                ret = c.checkHit(x, y);
            }
        }
        return ret;
    }

}
