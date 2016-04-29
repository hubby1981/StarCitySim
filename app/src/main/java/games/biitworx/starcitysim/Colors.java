package games.biitworx.starcitysim;

import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;

/**
 * Created by marcel.weissgerber on 15.04.2016.
 */
public class Colors {

    public static int backFillColor = Color.argb(255, 0, 0, 0);
    public static int foreFillColor = Color.argb(75, 255, 255, 255);
    public static int back001 = Color.argb(190, 20, 80, 120);
    public static Paint backPainter;
    public static Paint backPainterLine;
    public static Paint backPainterLine2;
    public static Paint backPainterLine3;

    public static int backContentFillColor = Color.argb(175, 0, 0, 0);
    public static Paint backPainterContent;
    public static Paint backPainterContentShader;
    public static Paint backPainterContentShader2;

    public static int outlineFillColor = Color.argb(255, 40, 70, 100);
    public static Paint outlinePainter;


    public static int outlineFillColor3 = Color.argb(75, 0, 0, 0);
    public static int outlineFillColor2 = Color.argb(50, 0, 0, 0);
    public static Paint outlinePainter2;
    public static Paint outlinePainter3;

    public static int inlineFillColor = Color.argb(255, 0, 180, 255);
    public static Paint inlinePainter;

    public static int topOutlineFillColor = Color.argb(128, 90, 220, 250);
    public static Paint topOutlinePainter;

    public static int leftOutlineFillColor = Color.argb(100, 0, 0, 200);
    public static Paint leftOutlinePainter;

    public static int backContentLineFillColor = Color.argb(255, 80, 200, 220);
    public static Paint backLinePainterContent;


    public static int color1 = Color.argb(180, 255, 255, 255);
    public static int color2 = Color.argb(180, 30, 200, 250);

    public static BitmapShader shaderBack;
    public static BitmapShader shaderBack2;


    static {
        outlinePainter = new Paint();
        outlinePainter.setColor(outlineFillColor);
        outlinePainter.setStyle(Paint.Style.FILL);

        outlinePainter2 = new Paint();
        outlinePainter2.setColor(outlineFillColor2);
        outlinePainter2.setStyle(Paint.Style.FILL);

        outlinePainter3 = new Paint();

        outlinePainter3.setStyle(Paint.Style.FILL);

        outlinePainter3.setAntiAlias(true);


        inlinePainter = new Paint();
        inlinePainter.setColor(inlineFillColor);
        inlinePainter.setStyle(Paint.Style.FILL);
        inlinePainter.setAntiAlias(true);


        backPainter = new Paint();
        backPainter.setColor(backFillColor);
        backPainter.setStyle(Paint.Style.FILL);

        backPainterContent = new Paint();
        backPainterContent.setColor(backContentFillColor);
        backPainterContent.setStyle(Paint.Style.FILL);

        backPainterContentShader = new Paint();
        backPainterContentShader2 = new Paint();

        backPainterContentShader2.setAntiAlias(true);
        backPainterContentShader.setAntiAlias(true);
        backPainterLine = new Paint();
        backPainterLine.setColor(backFillColor);
        backPainterLine.setStyle(Paint.Style.STROKE);
        backPainterLine.setStrokeWidth(2);

        backPainterLine2 = new Paint();
        backPainterLine2.setColor(foreFillColor);
        backPainterLine2.setStyle(Paint.Style.STROKE);
        backPainterLine2.setStrokeWidth(1);
        backPainterLine2.setAntiAlias(true);
        //backPainterLine2.setPathEffect(new DashPathEffect(new float[]{2f,2f,2f},2f));

        backPainterLine3 = new Paint();
        backPainterLine3.setColor(foreFillColor);
        backPainterLine3.setStyle(Paint.Style.STROKE);
        backPainterLine3.setStrokeWidth(1);
        //backPainterLine3.setPathEffect(new DashPathEffect(new float[]{4f, 4f, 4f}, 4f));

        topOutlinePainter = new Paint();
        topOutlinePainter.setColor(topOutlineFillColor);
        topOutlinePainter.setStyle(Paint.Style.FILL);

        leftOutlinePainter = new Paint();
        leftOutlinePainter.setColor(leftOutlineFillColor);
        leftOutlinePainter.setStyle(Paint.Style.FILL);

        backLinePainterContent = new Paint();
        backLinePainterContent.setColor(backContentLineFillColor);
        backLinePainterContent.setStyle(Paint.Style.FILL);
    }
}
