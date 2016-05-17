package games.biitworx.starcitysim.window.content;

import android.graphics.Canvas;
import android.graphics.Rect;

import games.biitworx.starcitysim.MenuRects;

/**
 * Created by marce_000 on 21.04.2016.
 */
public abstract class Content {
    protected float lineHeight = 1;
    private Rect content;
    private Rect full;

    private Rect click;
    private Runnable action = null;
    protected int seed = 10;
    public boolean wasHit = false;

    public Content() {

    }

    public Content(float lineHeight) {
        this.lineHeight = lineHeight;
    }

    public boolean hasAction() {
        return action != null;
    }

    public boolean isHit(int x, int y) {
        if (getContentRect() == null) return false;

        System.out.println("check hit " + getContentRect().toString() + " " + y);
        wasHit = getContentRect().contains(x, y);
        return getContentRect().contains(x, y);

    }

    public void setAction(Runnable action) {
        this.action = action;
    }

    public Runnable getAction() {
        return action;
    }

    public boolean checkHit(int x, int y) {
        return false;
    }

    public abstract void onDrawEx(Canvas canvas);

    public int onDraw(Canvas canvas, int yPos, int scroll) {
        Rect base = MenuRects.line.get();
        content = new Rect(base.left, yPos - scroll, base.right, (yPos - scroll) + (int) (base.height() * lineHeight));
        full = new Rect(base.left, yPos - scroll, base.right, (yPos - scroll) + (int) (base.height() * getLineHeight(false)));

        click = new Rect(content.left, content.top - base.height(), content.right, content.bottom - base.height());
        onDrawContents(yPos + (int) (base.height() * lineHeight), scroll);
        onDrawEx(canvas);

        return yPos + (int) (base.height() * getLineHeight(false));
    }

    public float getLineHeight(boolean extrude) {
        extrude = false;
        return extrude ? lineHeight < 1 ? 1f : lineHeight : lineHeight;
    }

    public Rect getContentRect() {
        return content;
    }

    public void setContentRect(Rect content){
        this.content = content;
    }

    public Rect getFullRect() {
        return full;
    }

    public Rect getInnerRect() {
        return new Rect(getContentRect().left + seed, getContentRect().top + seed, getContentRect().right - seed, getContentRect().bottom - seed);

    }

    public Rect getInnerFullRect() {
        return new Rect(getFullRect().left + seed, getFullRect().top + seed, getFullRect().right - seed, getFullRect().bottom - seed);

    }

    public Rect getClickRect() {
        return content;
    }

    public int onDrawInner(int yPos, int scroll) {
    return onDrawInner(yPos,scroll,0,0,0,0);

    }

    public int onDrawInner(int yPos, int scroll,int left,int right,int top,int bottom) {
        Rect base = MenuRects.line.get();
        if(left<=0)
            left=base.left;
        if(right<=0)
            right=base.right;
        if(top<=0)
            top= yPos - scroll;
        if(bottom<=0)
            bottom=(yPos - scroll) + (int) (base.height() * lineHeight);

        content = new Rect(left, top,right, bottom);

        if(bottom<=0)
            bottom=(yPos - scroll) + (int) (base.height() * getLineHeight(false));
        full = new Rect(left, top, right,bottom);

        click = new Rect(content.left, content.top - base.height(), content.right, content.bottom - base.height());
        return yPos + (int) (base.height() * lineHeight);

    }


    protected void onDrawContents(int yPos, int scroll) {

    }

    public String getValue() {
        return "";
    }
}
