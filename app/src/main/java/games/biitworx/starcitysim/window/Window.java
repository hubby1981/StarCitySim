package games.biitworx.starcitysim.window;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Menu;

import games.biitworx.starcitysim.MenuRects;

/**
 * Created by marce_000 on 21.04.2016.
 */
public abstract class Window {

    private int scrollPosition = 1;
    private String text = "";
    private Contents contents = new Contents();

    public Window(String text) {

        this.text = text;
    }

    public void onDraw(Canvas canvas) {
        Rect bounds = MenuRects.contentInner.get();
        int lines =  contents.getMaxLine()* MenuRects.line.get().height();

                int max = canvas.getHeight();

        if(max<lines)
            max=lines;
        Bitmap content = Bitmap.createBitmap(bounds.right,max, Bitmap.Config.ARGB_4444);

    }


}
