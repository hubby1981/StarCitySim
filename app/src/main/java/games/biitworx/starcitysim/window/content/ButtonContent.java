package games.biitworx.starcitysim.window.content;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
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

        Path pp = new Path();
        int w = innerContent.width() / 20;
        pp.moveTo(innerContent.left, innerContent.top);
        pp.lineTo(innerContent.right - w, innerContent.top);
        pp.lineTo(innerContent.right, innerContent.top + w);
        pp.lineTo(innerContent.right, innerContent.bottom);
        pp.lineTo(innerContent.left + w, innerContent.bottom);

        pp.lineTo(innerContent.left, innerContent.bottom - w);
        pp.close();

        innerContent = new Rect(innerContent.left+6,innerContent.top+6,innerContent.right-6,innerContent.bottom-6);
        Path pp2 = new Path();

        pp2.moveTo(innerContent.left, innerContent.top);
        pp2.lineTo(innerContent.right - w, innerContent.top);
        pp2.lineTo(innerContent.right, innerContent.top + w);
        pp2.lineTo(innerContent.right, innerContent.bottom);
        pp2.lineTo(innerContent.left + w, innerContent.bottom);

        pp2.lineTo(innerContent.left, innerContent.bottom - w);
        pp2.close();
        //RectHelper.drawRectGradient(innerContent, Color.argb(128, 0, 0, 0), Colors.back002, canvas);
        RectHelper.drawPathGradient(pp,innerContent, Color.argb(50, 0, 0, 0), Colors.back002, canvas);

        innerContent = new Rect(innerContent.left+w,innerContent.top,innerContent.right-w,innerContent.bottom);

        Rect topper = new Rect(innerContent.left, innerContent.top, innerContent.right, innerContent.top + 2);
        RectHelper.drawRectGradient(topper, Color.argb(255, 0, 0, 0), Colors.back003, canvas);
        Rect botter = new Rect(innerContent.left, innerContent.bottom, innerContent.right, innerContent.bottom + 2);
        RectHelper.drawRectGradient(botter, Color.argb(255, 0, 0, 0), Colors.back003, canvas);

        Fonts.FONT.setTextSize(innerContent.height() / (2 * getLineHeight()));

        canvas.drawText(text, innerContent.centerX() - (Fonts.FONT.getTextSize() * text.length() / 2), innerContent.centerY(), Fonts.FONT);
        //canvas.drawRect(innerContent, Colors.backPainterLine2);


        canvas.drawPath(pp2, Colors.backPainterLine3);
        canvas.drawPath(pp, Colors.backPainterLine3);

    }
}
