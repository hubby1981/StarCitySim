package games.biitworx.starcitysim.window;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by marce_000 on 21.04.2016.
 */
public abstract class Content {
    private int lineHeight=1;

    public Content(){

    }

    public Content(int lineHeight){
        this.lineHeight = lineHeight;
    }
    public abstract int onDraw(Canvas canvas,int yPos);
    public int getLineHeight(){
        return lineHeight;
    }
}
