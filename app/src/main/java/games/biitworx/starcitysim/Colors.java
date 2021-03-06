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

    public static int backFillColor = Color.argb(255, 0, 100,130);
    public static int foreFillColor = Color.argb(75, 255, 255, 255);
    public static int back001 = Color.argb(128, 15,130,160);
    public static int back002 = Color.argb(250, 0, 100, 130); // Backcolor header or button
    public static int back003 = Color.argb(255, 0, 100, 130); //Forline color header
    public static int back0021 = Color.argb(100, 0, 130, 100); // Backcolor header or button hits
    public static Paint backPainter;
    public static Paint backPainterLine;
    public static Paint backPainterLine2;
    public static Paint backPainterLine3;
    public static Paint backPainterLine4;

    public static int backContentFillColor = Color.argb(175, 0, 0, 0);
    public static Paint backPainterContent;
    public static Paint backPainterContentShader;
    public static Paint backPainterContentShader2;
    public static Paint backPainterContentShader3;
    public static int outlineFillColor = Color.argb(255, 40, 70, 100);
    public static Paint outlinePainter;


    public static int outlineFillColor3 = Color.argb(25, 0, 0, 0);
    public static int outlineFillColor2 = Color.argb(50, 0, 0, 0);
    public static Paint outlinePainter2;
    public static Paint outlinePainter3;

    public static int inlineFillColor = Color.argb(255, 0,100,130);
    public static Paint inlinePainter;

    public static int topOutlineFillColor = Color.argb(128,  80, 200, 220);
    public static Paint topOutlinePainter;

    public static int leftOutlineFillColor = Color.argb(100,  80, 200, 220);
    public static Paint leftOutlinePainter;

    public static int backContentLineFillColor = Color.argb(255, 80, 200, 220);
    public static Paint backLinePainterContent;


    public static int color1 = Color.argb(180, 255, 255, 255);
    public static int color2 = Color.argb(180, 30, 200, 250);

    public static BitmapShader shaderBack;
    public static BitmapShader shaderBack2;

    public static BitmapShader shaderBack3;



    public static BitmapShader rock001;
    public static BitmapShader rock002;
    public static BitmapShader rock003;
    public static BitmapShader rock004;
    public static BitmapShader rock005;

    public static BitmapShader ice001;
    public static BitmapShader ice002;
    public static BitmapShader ice003;
    public static BitmapShader ice004;
    public static BitmapShader ice005;


    public static BitmapShader gas001;
    public static BitmapShader gas002;
    public static BitmapShader gas003;
    public static BitmapShader gas004;
    public static BitmapShader gas005;

    public static BitmapShader water001;
    public static BitmapShader water002;
    public static BitmapShader water003;
    public static BitmapShader water004;
    public static BitmapShader water005;

    public static BitmapShader gras001;
    public static BitmapShader gras002;
    public static BitmapShader gras003;
    public static BitmapShader gras004;
    public static BitmapShader gras005;
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
        backPainterContentShader3= new Paint();

        backPainterContentShader2.setAntiAlias(true);
        backPainterContentShader.setAntiAlias(true);

        backPainterContentShader3.setAntiAlias(true);


        backPainterLine = new Paint();
        backPainterLine.setColor(foreFillColor);
        backPainterLine.setStyle(Paint.Style.STROKE);
        backPainterLine.setStrokeWidth(4);
        backPainterLine.setAntiAlias(true);
        backPainterLine.setPathEffect(new DashPathEffect(new float[]{8f, 8f, 8f}, 8f));

        backPainterLine4 = new Paint();
        backPainterLine4.setColor(foreFillColor);
        backPainterLine4.setStyle(Paint.Style.STROKE);
        backPainterLine4.setStrokeWidth(2);
        backPainterLine4.setAntiAlias(true);
        backPainterLine4.setPathEffect(new DashPathEffect(new float[]{4f, 4f, 4f}, 4f));

        backPainterLine2 = new Paint();
        backPainterLine2.setColor(foreFillColor);
        backPainterLine2.setStyle(Paint.Style.STROKE);
        backPainterLine2.setStrokeWidth(2);
        backPainterLine2.setAntiAlias(true);
        //backPainterLine2.setPathEffect(new DashPathEffect(new float[]{8f,8f,8f},8f));

        backPainterLine3 = new Paint();
        backPainterLine3.setColor(inlineFillColor);
        backPainterLine3.setStyle(Paint.Style.STROKE);
        backPainterLine3.setStrokeWidth(2);
        backPainterLine3.setAntiAlias(true);

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
