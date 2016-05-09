package games.biitworx.starcitysim.window.content;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.RectHelper;

/**
 * Created by marce_000 on 02.05.2016.
 */
public class SpacerContent extends Content {
boolean line = false;
    public SpacerContent(){
        this(1);
    }
    public SpacerContent(float space){
        this(space, false);
    }

    public SpacerContent(float space,boolean line){
        super(space);
        this.line = line;
    }
    @Override
    public void onDrawEx(Canvas canvas) {
        if(line) {
            Rect topper = new Rect(getInnerRect().left, getInnerRect().top + getInnerRect().height() / 2, getInnerRect().right, (getInnerRect().top + getInnerRect().height() / 2) + 2);
            RectHelper.drawRectGradient(topper, Color.argb(255, 0, 0, 0), Colors.back003, canvas);
        }
    }
}
