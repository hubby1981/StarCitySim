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
        super(1.75f);
        this.text = text;
        setAction(action);
    }

    @Override
    public void onDrawEx(Canvas canvas) {
        Rect innerContent = getInnerRect();
        int si = innerContent.width() / 8;
        innerContent = new Rect(innerContent.left + si, innerContent.top, innerContent.right - si, innerContent.bottom);

        Path pp = new Path();
        int w = innerContent.width() / 20;
        pp.moveTo(innerContent.left, innerContent.top);
        pp.lineTo(innerContent.right - w, innerContent.top);
        pp.lineTo(innerContent.right, innerContent.top + w);
        pp.lineTo(innerContent.right, innerContent.bottom);
        pp.lineTo(innerContent.left + w, innerContent.bottom);

        pp.lineTo(innerContent.left, innerContent.bottom - w);
        pp.close();

        Colors.outlinePainter.setColor(Color.argb(100, 0, 0, 0));
        canvas.drawPath(pp, Colors.outlinePainter);
        int a = 5;

        innerContent = new Rect(innerContent.left + a, innerContent.top + a, innerContent.right - a, innerContent.bottom - a);
        Path pp2 = new Path();

        pp2.moveTo(innerContent.left, innerContent.top);
        pp2.lineTo(innerContent.right - w, innerContent.top);
        pp2.lineTo(innerContent.right, innerContent.top + w);
        pp2.lineTo(innerContent.right, innerContent.bottom);
        pp2.lineTo(innerContent.left + w, innerContent.bottom);

        pp2.lineTo(innerContent.left, innerContent.bottom - w);
        pp2.close();
        //RectHelper.drawRectGradient(innerContent, Color.argb(128, 0, 0, 0), Colors.back002, canvas);
        RectHelper.drawPathGradient(pp2, innerContent, Colors.back002, Color.argb(200, 0, 0, 0), canvas);

        canvas.drawPath(pp2, Colors.backPainterContentShader3);

        innerContent = new Rect(innerContent.left + w, innerContent.top, innerContent.right - w, innerContent.bottom);

        Rect topper = new Rect(innerContent.left, innerContent.top - a, innerContent.right, innerContent.top);
        RectHelper.drawRectGradient(topper, Color.argb(255, 0, 0, 0), Colors.back003, canvas);
        Rect botter = new Rect(innerContent.left, innerContent.bottom, innerContent.right, innerContent.bottom + a);
        RectHelper.drawRectGradient(botter, Color.argb(255, 0, 0, 0), Colors.back003, canvas);

        Fonts.FONT.setTextSize(innerContent.height() / (getLineHeight() * 1.4f));
        float size = Fonts.FONT.measureText(text);
        canvas.drawText(text, innerContent.centerX() - size / 2, innerContent.centerY() + Fonts.FONT.getTextSize() / 2, Fonts.FONT);
        //canvas.drawRect(innerContent, Colors.backPainterLine2);


        canvas.drawPath(pp2, Colors.backPainterLine2);
        canvas.drawPath(pp, Colors.backPainterLine2);

    }
}
