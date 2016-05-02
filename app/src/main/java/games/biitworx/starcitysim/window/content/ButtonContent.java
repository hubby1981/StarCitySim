package games.biitworx.starcitysim.window.content;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Fonts;
import games.biitworx.starcitysim.RectHelper;

/**
 * Created by marce_000 on 02.05.2016.
 */
public class ButtonContent extends Content {
    public String text;

    public ButtonContent(String text) {
        this(text, null);
    }

    public ButtonContent(String text, Runnable action) {
        super(2);
        this.text = text;
        setAction(action);
    }

    @Override
    public void onDrawEx(Canvas canvas) {
        Rect innerContent = getInnerRect();

        RectHelper.drawRectGradient(innerContent, Color.argb(255, 0, 0, 0), Colors.back002, canvas);

        Rect topper = new Rect(innerContent.left, innerContent.top, innerContent.right, innerContent.top + 1);
        RectHelper.drawRectGradient(topper, Color.argb(255, 0, 0, 0), Colors.back003, canvas);
        Rect botter = new Rect(innerContent.left, innerContent.bottom, innerContent.right, innerContent.bottom + 1);
        RectHelper.drawRectGradient(botter, Color.argb(255, 0, 0, 0), Colors.back003, canvas);

        Fonts.FONT.setTextSize(innerContent.height() / (2 * getLineHeight()));

        canvas.drawText(text, innerContent.centerX() - (Fonts.FONT.getTextSize() * text.length() / 2), innerContent.centerY(), Fonts.FONT);
        canvas.drawRect(innerContent, Colors.backPainterLine2);
    }
}
