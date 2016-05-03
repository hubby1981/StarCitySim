package games.biitworx.starcitysim.window.content;

import android.graphics.Canvas;
import android.graphics.Rect;

import games.biitworx.starcitysim.MenuRects;

/**
 * Created by marce_000 on 21.04.2016.
 */
public abstract class Content {
    protected int lineHeight = 1;
    private Rect content;
    private Rect click;
    private Runnable action=null;
    protected int seed = 10;
    public Content() {

    }

    public Content(int lineHeight) {
        this.lineHeight = lineHeight;
    }

    public boolean hasAction(){
        return action!=null;
    }

    public boolean isHit(int x,int y){
        if(getContentRect()==null)return false;

        System.out.println("check hit "+getContentRect().toString()+" "+y);
        return getContentRect().contains(x,y);
    }

    public void setAction(Runnable action){
        this.action = action;
    }

    public Runnable getAction(){
        return action;
    }

    public abstract void onDrawEx(Canvas canvas);

    public int onDraw(Canvas canvas, int yPos, int scroll) {
        Rect base = MenuRects.line.get();
        content = new Rect(base.left, yPos - scroll, base.right, (yPos - scroll) + base.height()*lineHeight);
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

    public Rect getInnerRect(){
        return new Rect(getContentRect().left+seed, getContentRect().top+seed , getContentRect().right-seed , getContentRect().bottom-seed);

    }

    public Rect getClickRect() {
        return content;
    }
}
