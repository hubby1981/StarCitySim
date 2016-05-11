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
    public boolean center = false;
    public int padding=0;

    public TextContent(String text) {
        this(text, -1, 2f);


    }

    public TextContent(String text, int color) {
        this(text, color, 2f);


    }

    public TextContent(String text, int color, float size) {
        this(text, color, size, 3f);
    }

    public TextContent(String text, int color, float size, float height) {
        this(text, color, size, height, false);
    }

    public TextContent(String text, int color, float size, float height, boolean line) {
        super(size);
        this.text = text;
        this.line = line;
        this.size = height;
        this.color = color;
    }


    public TextContent centered(boolean center) {
        this.center = center;
        return this;
    }

    public TextContent text(String text){
        this.text = text;
        return this;
    }
    public TextContent padding(int padding){
        this.padding = padding;
        return this;
    }

    @Override
    public void onDrawEx(Canvas canvas) {
        Fonts.FONT.setTextSize((getInnerRect().height() / size));

        if (line)
            canvas.drawLine(getInnerRect().left, getInnerRect().top + getInnerRect().height() / 2, getInnerRect().right, getInnerRect().top + getInnerRect().height() / 2, Colors.backPainterLine);
        int old = Fonts.FONT.getColor();
        if (color != -1) {


            Fonts.FONT.setColor(color);
        }
        float si = Fonts.FONT.measureText(text);
        int p = padding>0?getInnerRect().width()/padding:0;
        if (!center)
            canvas.drawText(text, getInnerRect().left + (float) (getInnerRect().height() / 1.5)+p, getInnerRect().centerY(), Fonts.FONT);
        else
            canvas.drawText(text, getInnerRect().centerX()-si/2 ,getInnerRect().centerY(), Fonts.FONT);

        if (color != -1) {
            Fonts.FONT.setColor(old);
        }
    }

    @Override
    public String getValue() {
        return text;
    }
}
