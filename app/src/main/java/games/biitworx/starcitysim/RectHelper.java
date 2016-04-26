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

    public static ArrayList<Rect> makeRects(Rect base, int countW) {
        ArrayList<Rect> result = new ArrayList<>();

        int w = base.width() / (countW * 2);
        int x = base.left;
        int y = base.top;
        int h = base.height();
        boolean space = false;

        int w2 = w / 4;
        w += w - w2;

        w += (w2 / countW);
        h -= w2 * 2;
        for (int i = 0; i < (countW * 2) - 1; i++) {
            if (!space) {
                result.add(new Rect(x, y, (x + w), y + h));
                x += w;

            } else {
                result.add(new Rect(x, y, x + w2, y + h));
                x += w2;
            }
            space = !space;
        }
        return result;
    }

    public static ArrayList<Rect> makeRects2(Rect base, int countW) {
        ArrayList<Rect> result = new ArrayList<>();

        int w = base.width() / (countW * 2);
        int x = base.left;
        int y = base.top;
        int h = base.height();
        boolean space = false;

        int w2 = w / 4;
        w += w - w2;

        w += (w2 / countW);
        h -= w2 * 2;
        for (int i = 0; i < (countW * 2) - 1; i++) {
            if (!space) {
                result.add(new Rect(x, y, (x + w), y + w));
                x += w;

            } else {
                result.add(new Rect(x, y, x + w2, y + w));
                x += w2;
            }
            space = !space;
        }
        return result;
    }

    public static ArrayList<Rect> makeRect3(Rect base, int height, int space, int more) {
        ArrayList<Rect> result = new ArrayList<>();
        int max = base.height() / height;
        max = ((base.height() - (space * max))) / height;

        int y = base.top;

        for (int x = 0; x < max + more; x++) {
            result.add(new Rect(base.left, y, base.right, y + height));
            y += height + space;
        }

        return result;
    }

}
