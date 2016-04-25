package games.biitworx.starcitysim;

import android.graphics.Rect;

/**
 * Created by marcel.weissgerber on 20.04.2016.
 */
public class RectContainer extends Container<Rect> {
    private boolean visible = true;
    private Runnable action=null;
    public RectContainer(Rect item) {
        super(item);
    }

    public RectContainer(Rect item,Runnable action) {
        super(item);
        this.action = action;
    }

    @Override
    public Rect get() {
        return isVisible()?getItem():new Rect(0,0,0,0);
    }

    public RectContainer(Rect item,boolean visible) {
        super(item);
        this.visible = visible;
    }
    public  boolean isVisible(){
        return visible;
    }

    public boolean hit(int x,int y){
        return get().contains(x,y);
    }

    public Runnable getAction(){
        return action;
    }

    public boolean hasAction(){
        return getAction()!=null;
    }

}
