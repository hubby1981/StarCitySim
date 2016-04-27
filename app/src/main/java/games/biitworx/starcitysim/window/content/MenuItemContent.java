package games.biitworx.starcitysim.window.content;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;

import java.util.ArrayList;

import games.biitworx.starcitysim.BitmapDrawer;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Fonts;
import games.biitworx.starcitysim.RectHelper;
import games.biitworx.starcitysim.window.content.Content;

/**
 * Created by marcel.weissgerber on 26.04.2016.
 */
public class MenuItemContent extends Content {
    private int color;
    private String primary;
    private String secondary;
    private String info;
    private Bitmap icon;
    private Bitmap back;

    private int seed=10;
    public MenuItemContent(Bitmap icon,Bitmap back, String primary,String secondary,String info, int color) {
        this(icon,back,primary,secondary,info,color,null);
    }

    public MenuItemContent(Bitmap icon,Bitmap back, String primary,String secondary,String info, int color,Runnable action) {
        super(3);
        this.icon = icon;
        this.primary = primary;
        this.secondary = secondary;
        this.info = info;
        this.color = color;
        this.back = back;
        setAction(action);
    }

    @Override
    public void onDrawEx(Canvas canvas) {

        Rect innerContent = new Rect(getContentRect().left+seed,getContentRect().top+seed,getContentRect().right-seed,getContentRect().bottom-seed);

        Paint filler = new Paint();

        filler.setStyle(Paint.Style.FILL);
        filler.setShader(new LinearGradient((float) innerContent.left, (float) innerContent.top, (float) innerContent.right, (float) innerContent.top, color, Color.argb(175, 0, 0, 0), Shader.TileMode.REPEAT));



        canvas.drawRect(innerContent, filler);
        BitmapDrawer.drawImage(back, canvas, new Rect(innerContent.right - (int)(innerContent.width()/2), innerContent.top, innerContent.right, innerContent.bottom), null,false);


        ArrayList<Rect> rects = RectHelper.makeRects2(innerContent, 6);
        if(icon!=null)
            BitmapDrawer.drawImage(icon,canvas,new Rect(rects.get(0).left,rects.get(0).top+rects.get(0).height()/4,rects.get(0).right,rects.get(0).bottom+rects.get(0).height()/4),null,false);

        Rect text = RectHelper.combine(rects,1,3);

        if(icon==null){
            //rects = RectHelper.makeRects2(innerContent, 12);
            //text = RectHelper.combine(rects,1,8);
        }
        Fonts.FONT.setTextSize((getContentRect().height() / 6));

        rects = RectHelper.makeRect3(text,(int)Fonts.FONT.getTextSize(),2,1);


        canvas.drawText(primary, (float) rects.get(1).left, rects.get(1).centerY(), Fonts.FONT);
        Fonts.FONT.setTextSize((getContentRect().height() / 9));
        canvas.drawText(secondary, (float) rects.get(1).left, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 1.8), Fonts.FONT);
        canvas.drawText(info, (float) rects.get(1).left, rects.get(1).centerY()+(float)(Fonts.FONT.getTextSize()*3.2), Fonts.FONT);

        //canvas.drawText(secondary+" ["+info+"]",(float)rects.get(2).left,rects.get(2).centerY(),Fonts.FONT);
        //canvas.drawText(info,(float)rects.get(3).left,rects.get(3).centerY(),Fonts.FONT);



        canvas.drawRect(innerContent, Colors.backPainterLine2);

    }
}
