package games.biitworx.starcitysim.window;

import android.graphics.Canvas;
import android.graphics.Rect;

import games.biitworx.starcitysim.MenuRects;

/**
 * Created by marce_000 on 21.04.2016.
 */
public abstract class Content {
    private int lineHeight = 1;
    private Rect content;
    private Rect click;

    public Content() {

    }

    public Content(int lineHeight) {
        this.lineHeight = lineHeight;
    }

    public abstract void onDrawEx(Canvas canvas);

    public int onDraw(Canvas canvas, int yPos, int scroll) {
        Rect base = MenuRects.line.get();
        content = new Rect(base.left, yPos - scroll, base.right, (yPos - scroll) + base.height());
        click = new Rect(content.left, content.top - base.height(), content.right, content.bottom - base.height());
        onDrawEx(canvas);
        return yPos + getContentRect().height();
    }

    public int getLineHeight() {
        return lineHeight;
    }

    public Rect getContentRect() {
        return content;
    }

    public Rect getClickRect() {
        return content;
    }
}
