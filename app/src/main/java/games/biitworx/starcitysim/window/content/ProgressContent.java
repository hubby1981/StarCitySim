package games.biitworx.starcitysim.window.content;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Fonts;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.RectHelper;

/**
 * Created by marcel.weissgerber on 09.05.2016.
 */
public class ProgressContent extends Content {
    private int value = 0;

    @Override
    public void onDrawEx(Canvas canvas) {
        Rect innerContent = getContentRect();
        value = Game.COUNT;
        int a = 5;
        if(value<0)value=0;
        if(value>100)value=100;

        float si = (innerContent.right - innerContent.left) / 100f;
        si *= value;

        RectHelper.drawRectGradient2(new Rect(innerContent.left, innerContent.top, (int) (innerContent.left + si), innerContent.bottom), Color.argb(100, 10, 10, 30), Colors.back002, canvas);
        canvas.drawRect(innerContent, Colors.backPainterContentShader3);

        Rect topper = new Rect(innerContent.left, innerContent.top - a, innerContent.right, innerContent.top);
        RectHelper.drawRectGradient(topper, Color.argb(255, 0, 0, 0), Colors.back003, canvas);
        Rect botter = new Rect(innerContent.left, innerContent.bottom, innerContent.right, innerContent.bottom + a);
        RectHelper.drawRectGradient(botter, Color.argb(255, 0, 0, 0), Colors.back003, canvas);

        Fonts.FONT.setTextSize(innerContent.height() / (getLineHeight() * 1.8f));
        float size = Fonts.FONT.measureText(value + " %");
        canvas.drawText(value + " %", innerContent.centerX() - size / 2, innerContent.centerY() + Fonts.FONT.getTextSize() / 2, Fonts.FONT);

        canvas.drawRect(innerContent, Colors.backPainterLine2);

    }
}
