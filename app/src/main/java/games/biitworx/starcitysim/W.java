package games.biitworx.starcitysim;

import java.util.ArrayList;
import java.util.HashMap;

import games.biitworx.starcitysim.window.Window;

/**
 * Created by marcel.weissgerber on 04.05.2016.
 */
public class W {


    public static ArrayList<Window> lastWindow = new ArrayList<>();

    public static Window get(Window wnd) {
        Window result = wnd;
        if (lastWindow.contains(wnd))
            wnd = lastWindow.get(lastWindow.indexOf(wnd));

        addLast(result);
        return result;
    }


    public static void addLast(Window last) {
        lastWindow.add(last);
    }

    public static Window getLast() {
        if (lastWindow.size() < 2) return null;
        int last = lastWindow.size() - 2;
        Window result = lastWindow.get(last);
        lastWindow.remove(lastWindow.size()-1);


        return result;
    }

}
