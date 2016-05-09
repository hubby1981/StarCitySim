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
    private float size = 3f;
    private int color = -1;

    public TextContent(String text) {
        this(text,-1, 2f);


    }

    public TextContent(String text, int color) {
        this(text,color, 2f);


    }

    public TextContent(String text, int color, float size) {
        this(text,color, size, 3f);
    }

    public TextContent(String text, int color, float size, float height) {
        this(text,color, size, height, false);
    }

    public TextContent(String text, int color, float size, float height, boolean line) {
        super(size);
        this.text = text;
        this.line = line;
        this.size = height;
        this.color = color;
    }

    @Override
    public void onDrawEx(Canvas canvas) {
        Fonts.FONT.setTextSize((getInnerRect().height() / size));

        if (line)
            canvas.drawLine(getInnerRect().left, getInnerRect().top + getInnerRect().height() / 2, getInnerRect().right, getInnerRect().top + getInnerRect().height() / 2, Colors.backPainterLine2);
        int old = Fonts.FONT.getColor();
        if(color!=-1){


            Fonts.FONT.setColor(color);
        }
        canvas.drawText(text, getInnerRect().left + (float) (getInnerRect().height() / 1.5), getInnerRect().centerY(), Fonts.FONT);


        if(color!=-1){
            Fonts.FONT.setColor(old);
        }
    }

    @Override
    public String getValue() {
        return text;
    }
}
