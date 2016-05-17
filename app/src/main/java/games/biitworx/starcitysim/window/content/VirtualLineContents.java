package games.biitworx.starcitysim.window.content;

import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;

import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.MenuRects;
import games.biitworx.starcitysim.RectHelper;

/**
 * Created by marcel.weissgerber on 17.05.2016.
 */
public class VirtualLineContents extends Content {
    private List<Content> contents = new ArrayList<>();


    public VirtualLineContents() {
        this(1.75f);
    }

    public VirtualLineContents(float max) {
        super(max);

    }

    public List<Content> getContents(){
        return contents;
    }

    @Override
    protected void onDrawContents(int yPos, int scroll) {

        yPos -=MenuRects.line.get().height()*1.5f;
        ArrayList<Rect> rects = RectHelper.makeRectsEx(getInnerFullRect(), contents.size());
        int index = 0;
        for (Content c : contents) {
            if (c != null) {

                c.onDrawInner(yPos, scroll,rects.get(index).left,rects.get(index).right,0,0);
                index++;


            }
        }

    }

    @Override
    public boolean checkHit(int x, int y) {
        for (Content c : contents) {
            if (c.hasAction() && c.isHit(x, y)) {
                c.getAction().run();
                return true;
            }
        }
        return false;
    }

    @Override
    public void onDrawEx(Canvas canvas) {


        for (Content c : contents)
            c.onDrawEx(canvas);
    }

}
