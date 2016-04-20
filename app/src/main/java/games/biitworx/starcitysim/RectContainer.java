package games.biitworx.starcitysim;

import android.graphics.Rect;

/**
 * Created by marcel.weissgerber on 20.04.2016.
 */
public class RectContainer extends Container<Rect> {
    private boolean visible = true;
    public RectContainer(Rect item) {
        super(item);
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

}
