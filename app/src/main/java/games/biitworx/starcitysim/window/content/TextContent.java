package games.biitworx.starcitysim.window.content;

import android.graphics.Canvas;

import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Fonts;
import games.biitworx.starcitysim.window.content.Content;

/**
 * Created by marcel.weissgerber on 22.04.2016.
 */
public class TextContent extends Content {
    private String text = "";
    private boolean line = false;
    private float size=3f;

    public TextContent(String text) {
        this(text, 2f);


    }

    public TextContent(String text, float size) {
        this(text,size,3f);
    }

    public TextContent(String text, float size,float height) {
        this(text,size,height,false);
    }

    public TextContent(String text,float size,float height, boolean line) {
        super(size);
        this.text = text;
        this.line = line;
        this.size=height;
    }

    @Override
    public void onDrawEx(Canvas canvas) {
        Fonts.FONT.setTextSize((getInnerRect().height() / size));

        if(line)
            canvas.drawLine(getInnerRect().left,getInnerRect().top+getInnerRect().height()/2,getInnerRect().right,getInnerRect().top+getInnerRect().height()/2, Colors.backPainterLine2);

        canvas.drawText(text, getInnerRect().left + (float) (getInnerRect().height() / 1.5), getInnerRect().centerY(), Fonts.FONT);

    }

    @Override
    public String getValue() {
        return text;
    }
}
