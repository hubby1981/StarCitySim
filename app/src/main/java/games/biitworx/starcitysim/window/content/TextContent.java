package games.biitworx.starcitysim.window.content;

import android.graphics.Canvas;

import games.biitworx.starcitysim.Fonts;
import games.biitworx.starcitysim.window.content.Content;

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
        Fonts.FONT.setTextSize((getContentRect().height() / 3));

        canvas.drawText(text,0,getContentRect().top,Fonts.FONT);

    }
}
