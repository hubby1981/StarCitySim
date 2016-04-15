package games.biitworx.starcitysim;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by marcel.weissgerber on 15.04.2016.
 */
public class Colors {

    public static int backFillColor = Color.argb(255, 0, 0, 0);
    public static Paint backPainter;
    public static Paint backPainterLine;

    public static int backContentFillColor = Color.argb(200, 0, 0, 0);
    public static Paint backPainterContent;

    public static int outlineFillColor = Color.argb(255, 40, 70, 100);
    public static Paint outlinePainter;

    public static int inlineFillColor = Color.argb(255, 0, 180, 255);
    public static Paint inlinePainter;

    public static int topOutlineFillColor = Color.argb(128, 90, 220, 250);
    public static Paint topOutlinePainter;

    public static int leftOutlineFillColor = Color.argb(180, 160, 220, 250);
    public static Paint leftOutlinePainter;


    public static int color1 = Color.argb(180, 255,255,255);
    public static int color2 = Color.argb(180, 30, 200, 250);


    static {
        outlinePainter = new Paint();
        outlinePainter.setColor(outlineFillColor);
        outlinePainter.setStyle(Paint.Style.FILL);

        inlinePainter = new Paint();
        inlinePainter.setColor(inlineFillColor);
        inlinePainter.setStyle(Paint.Style.FILL);

        backPainter = new Paint();
        backPainter.setColor(backFillColor);
        backPainter.setStyle(Paint.Style.FILL);

        backPainterContent = new Paint();
        backPainterContent.setColor(backContentFillColor);
        backPainterContent.setStyle(Paint.Style.FILL);

        backPainterLine = new Paint();
        backPainterLine.setColor(backFillColor);
        backPainterLine.setStyle(Paint.Style.STROKE);
        backPainterLine.setStrokeWidth(2);

        topOutlinePainter = new Paint();
        topOutlinePainter.setColor(topOutlineFillColor);
        topOutlinePainter.setStyle(Paint.Style.FILL);

        leftOutlinePainter = new Paint();
        leftOutlinePainter.setColor(leftOutlineFillColor);
        leftOutlinePainter.setStyle(Paint.Style.FILL);

    }
}
