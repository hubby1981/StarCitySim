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
        super(2);
        this.text = text;

    }


    @Override
    public void onDrawEx(Canvas canvas) {
        Fonts.FONT.setTextSize((getInnerRect().height() / 3));

        canvas.drawText(text,getInnerRect().left+(float)(getInnerRect().height()/1.5),getInnerRect().centerY(),Fonts.FONT);

    }

    @Override
    public String getValue(){
        return text;
    }
}
