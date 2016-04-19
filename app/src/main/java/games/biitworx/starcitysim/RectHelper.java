package games.biitworx.starcitysim;

import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by marcel.weissgerber on 19.04.2016.
 */
public class RectHelper {

    public static Rect combine(ArrayList<Rect> rects, int start,int end){
        return new Rect(rects.get(start).left,rects.get(start).top,rects.get(end).right,rects.get(end).bottom);
    }
}
