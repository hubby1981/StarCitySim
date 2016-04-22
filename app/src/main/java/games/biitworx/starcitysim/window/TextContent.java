package games.biitworx.starcitysim.window;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Fonts;
import games.biitworx.starcitysim.MenuRects;

/**
 * Created by marcel.weissgerber on 22.04.2016.
 */
public class TextContent extends Content {
    private String text="";

    public TextContent(String text){
        super();
        this.text = text;

    }


    @Override
    public void onDrawEx(Canvas canvas) {
        Fonts.FONT.setTextSize((getContentRect().height() / 2));

        canvas.drawText(text,0,getContentRect().top,Fonts.FONT);

    }
}
