package games.biitworx.starcitysim.window.content;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;

import java.util.ArrayList;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.BitmapDrawer;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.RectHelper;

/**
 * Created by marce_000 on 18.05.2016.
 */
public class PlanetsContent extends Content {
    private int bitmap;

    public PlanetsContent(int bitmap) {
        super(5);
        this.bitmap = bitmap;
    }

    @Override
    public void onDrawEx(Canvas canvas) {
        Rect innerContent = getInnerRect();

        ArrayList<Rect> rects = RectHelper.makeRectsEx(innerContent, 5);
        Rect circle = rects.get(2);
        Path p = new Path();

        p.addCircle(circle.exactCenterX(), circle.exactCenterY(), circle.height() / 3, Path.Direction.CW);


        p.close();
        Bitmap bit = Bitmap.createBitmap(circle.width(), circle.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas1 = new Canvas(bit);

        BitmapDrawer.drawImage(B.get(bitmap), canvas1, new Rect(0, 0, circle.width(), circle.height()), null, true);

        canvas1.clipPath(p, Region.Op.DIFFERENCE);
        BitmapDrawer.drawImage(bit, canvas, circle, null, false);

        Colors.backPainterLine2.setStyle(Paint.Style.FILL);
        int oldColor = Colors.backPainterLine2.getColor();
        Colors.backPainterLine2.setColor(Color.argb(50, 20, 200, 200));

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
