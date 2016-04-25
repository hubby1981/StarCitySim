package games.biitworx.starcitysim;

import android.graphics.Rect;

/**
 * Created by marcel.weissgerber on 20.04.2016.
 */
public class MenuRects {

    public static RectContainer menu;
    public static RectContainer icon;
    public static RectContainer info;

    public static RectContainer action1;
    public static RectContainer action2;
    public static RectContainer action3;
    public static RectContainer action4;
    public static RectContainer action5;
    public static RectContainer action6;

    public static RectContainer content;
    public static RectContainer contentInner;


    public static RectContainer line;


    public static void testHit(int x, int y) {
        if (menu.hit(x, y) && menu.hasAction())
            menu.getAction().run();
        else if (icon.hit(x, y) && icon.hasAction())
            icon.getAction().run();
    }
}
