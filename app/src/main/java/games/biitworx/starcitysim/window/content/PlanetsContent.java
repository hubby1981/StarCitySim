package games.biitworx.starcitysim.window.content;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;

import java.util.ArrayList;

import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.RectHelper;

/**
 * Created by marce_000 on 18.05.2016.
 */
public class PlanetsContent extends Content {
private Shader shader;
    public PlanetsContent(Shader shader) {
        super(5);
        this.shader=shader;
    }

    @Override
    public void onDrawEx(Canvas canvas) {
        Rect innerContent = getInnerRect();

        ArrayList<Rect> rects = RectHelper.makeRectsEx(innerContent, 5);
        Rect circle = rects.get(2);
        Path p = new Path();

        p.addCircle(circle.exactCenterX(), circle.exactCenterY(), circle.height() / 3, Path.Direction.CW);

        p.close();

        Colors.backPainterLine2.setShader(shader);
        Colors.backPainterLine2.setStyle(Paint.Style.FILL);
        int oldColor = Colors.backPainterLine2.getColor();
        Colors.backPainterLine2.setColor(Color.argb(255, 20, 200, 200));

        Colors.backPainterLine2.setAntiAlias(true);

        float old = Colors.backPainterLine2.getStrokeWidth();
        canvas.drawPath(p, Colors.backPainterLine2);

        Colors.backPainterLine2.setShadowLayer(10, 0, 0, Color.argb(255, 0, 200, 200));



        Colors.backPainterLine2.setShadowLayer(0, 0, 0, Color.argb(255, 0, 200, 200));
        LinearGradient grad = new LinearGradient((circle.left - circle.width() / 8), circle.exactCenterY(), circle.right + circle.width() / 2, circle.exactCenterY(), Color.argb(255, 0, 0, 0), Color.argb(100, 0, 0, 0), Shader.TileMode.MIRROR);
        Colors.backPainterLine2.setShader(grad);

        canvas.drawPath(p, Colors.backPainterLine2);

        Colors.backPainterLine2.setStrokeWidth(10);
        Colors.backPainterLine2.setStyle(Paint.Style.STROKE);

        Colors.backPainterLine2.setColor(oldColor);


        Colors.backPainterLine2.setStrokeWidth(old);
        Colors.backPainterLine2.setShader(null);
        Colors.backPainterLine2.setAntiAlias(true);


    }
}
