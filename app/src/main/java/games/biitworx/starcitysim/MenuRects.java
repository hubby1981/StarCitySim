package games.biitworx.starcitysim;

import android.graphics.Rect;

/**
 * Created by marcel.weissgerber on 20.04.2016.
 */
public class MenuRects {

    public static RectContainer menu;
    public static RectContainer icon;
    public static RectContainer info;


    public static RectContainer content;
    public static RectContainer contentInner;


    public static RectContainer line;
    public static RectContainer notification;


    public static void testHit(int x, int y) {
        if (menu.hit(x, y) && menu.hasAction())
            menu.getAction().run();

    }
}
