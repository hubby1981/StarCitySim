package games.biitworx.starcitysim;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;

import java.util.ArrayList;

/**
 * Created by marcel.weissgerber on 19.04.2016.
 */
public class RectHelper {

    public static Rect combine(ArrayList<Rect> rects, int start,int end){
        return new Rect(rects.get(start).left,rects.get(start).top,rects.get(end).right,rects.get(end).bottom);
    }

    public static void drawRectGradient(Rect rc,int color1,int color2,Canvas canvas){


        RectF rc1 = new RectF(rc.left,rc.top,rc.right-rc.width()/2,rc.bottom);
        RectF rc2 = new RectF(rc.left+rc.width()/2,rc.top,rc.right,rc.bottom);

        LinearGradient gr1 = new LinearGradient(rc1.left,rc1.centerY(),rc1.right-rc.width()/8,rc1.centerY(),color1,color2, Shader.TileMode.CLAMP);
        LinearGradient gr2 = new LinearGradient(rc2.left+rc.width()/8,rc2.centerY(),rc2.right,rc2.centerY(),color2,color1, Shader.TileMode.CLAMP);


        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setShader(gr1);

        canvas.drawRect(rc1, p);
        p.setShader(gr2);

        canvas.drawRect(rc2,p);

    }
    public static void drawRectGradient2(Rect rc,int color1,int color2,Canvas canvas){


        RectF rc1 = new RectF(rc.left,rc.top,rc.right,rc.bottom);


        LinearGradient gr1 = new LinearGradient(rc1.left,rc1.centerY(),rc1.right,rc1.centerY(),color1,color2, Shader.TileMode.CLAMP);

        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setShader(gr1);

        canvas.drawRect(rc1, p);


    }
    public static void drawPathGradient(Path p1,Rect rc,int color1,int color2,Canvas canvas){


        RectF rc1 = new RectF(rc.left,rc.top,rc.right-rc.width()/2,rc.bottom);
        RectF rc2 = new RectF(rc.left+rc.width()/2,rc.top,rc.right,rc.bottom);

        LinearGradient gr1 = new LinearGradient(rc1.left,rc1.centerY(),rc1.right-rc.width()/8,rc1.centerY(),color1,color2, Shader.TileMode.CLAMP);
        LinearGradient gr2 = new LinearGradient(rc2.left+rc.width()/8,rc2.centerY(),rc2.right,rc2.centerY(),color2,color1, Shader.TileMode.CLAMP);

        RadialGradient gr3 = new RadialGradient(rc.exactCenterX(),rc.exactCenterY(),rc.width()/1.5f,color1,color2, Shader.TileMode.CLAMP);

        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setAntiAlias(true);
        p.setShader(gr3);

        canvas.drawPath(p1, p);
        p.setShader(gr2);

        //canvas.drawPath(p1,p);

    }

    public static ArrayList<Rect> makeRects(Rect base, int countW) {
        ArrayList<Rect> result = new ArrayList<>();

        int w = base.width() / (countW * 2);
        int x = base.left;
        int y = base.top;
        int h = base.height();
        boolean space = false;

        int w2 = w / 4;
        w += w - w2;

        w += (w2 / countW);
        h -= w2 * 2;
        for (int i = 0; i < (countW * 2) - 1; i++) {
            if (!space) {
                result.add(new Rect(x, y, (x + w), y + h));
                x += w;

            } else {
                result.add(new Rect(x, y, x + w2, y + h));
                x += w2;
            }
            space = !space;
        }
        return result;
    }

    public static ArrayList<Rect> makeRects2(Rect base, int countW) {
        ArrayList<Rect> result = new ArrayList<>();

        int w = base.width() / (countW * 2);
        int x = base.left;
        int y = base.top;
        int h = base.height();
        boolean space = false;

        int w2 = w / 4;
        w += w - w2;

        w += (w2 / countW);
        h -= w2 * 2;
        for (int i = 0; i < (countW * 2) - 1; i++) {
            if (!space) {
                result.add(new Rect(x, y, (x + w), y + w));
                x += w;

            } else {
                result.add(new Rect(x, y, x + w2, y + w));
                x += w2;
            }
            space = !space;
        }
        return result;
    }

    public static ArrayList<Rect> makeRect3(Rect base, int height, int space, int more) {
        ArrayList<Rect> result = new ArrayList<>();
        int max = base.height() / height;
        max = ((base.height() - (space * max))) / height;

        int y = base.top;

        for (int x = 0; x < max + more; x++) {
            result.add(new Rect(base.left, y, base.right, y + height));
            y += height + space;
        }

        return result;
    }

    public static ArrayList<Rect> makeRect4(Rect base,int height){
        ArrayList<Rect> result = new ArrayList<>();
        int max = base.height()/height*2;
        int y=base.top;
        for(int x=0;x<max;x++){
            y+=1;
            result.add(new Rect(base.left,y,base.right,y+1));
            y+=1;
        }
        return result;
    }

}
