package games.biitworx.starcitysim.window.content;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;

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


    public MenuItemContent(Bitmap icon, Bitmap back, String primary, String secondary, String info, int color) {
        this(icon, back, primary, secondary, info, color, null);
    }

    public MenuItemContent(Bitmap icon, Bitmap back, String primary, String secondary, String info, int color, Runnable action) {
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

        Rect innerContent = getInnerRect();
        Paint filler = new Paint();

        filler.setStyle(Paint.Style.FILL);

        Paint filler2 = new Paint();

        filler2.setStyle(Paint.Style.FILL);
        filler2.setColor(color);
        filler.setShader(new LinearGradient((float) innerContent.left, (float) innerContent.top, (float) innerContent.right, (float) innerContent.top, color, Color.argb(150, 0, 0, 0), Shader.TileMode.REPEAT));


        canvas.drawRect(innerContent, filler);


        BitmapDrawer.drawImage(back, canvas, new Rect(innerContent.right - (int) (innerContent.height() *2.5), innerContent.top, innerContent.right, innerContent.bottom), null, false);


        ArrayList<Rect> rects = RectHelper.makeRects2(innerContent, 6);
        if (icon != null)
            BitmapDrawer.drawImage(icon, canvas, new Rect(rects.get(0).left, rects.get(0).top + rects.get(0).height() / 4, rects.get(0).right, rects.get(0).bottom + rects.get(0).height() / 4), null, false);

        Rect text = RectHelper.combine(rects, 1, 3);

        if (icon == null) {
            rects = RectHelper.makeRects2(innerContent, 20);
            text = RectHelper.combine(rects, 1, 14);

            Rect rc1 = new Rect(rects.get(0).left, innerContent.top, rects.get(0).left + rects.get(0).width() / 4, innerContent.bottom);


        }
        Fonts.FONT.setTextSize((getContentRect().height() / 4.85f));

        rects = RectHelper.makeRect3(text, (int) Fonts.FONT.getTextSize(), 2, 2);

        int hh = getContentRect().height() / 10;
        canvas.drawText(primary, (float) rects.get(1).left, rects.get(1).centerY() -hh, Fonts.FONT);

        Fonts.FONT.setTextSize((getContentRect().height() / 7));

        canvas.drawText(secondary, (float) rects.get(1).left, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 0.8), Fonts.FONT);
        Fonts.FONT.setTextSize((getContentRect().height() / 6));

        canvas.drawText(info, (float) rects.get(1).left, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 2.5), Fonts.FONT);



        //canvas.drawText(secondary+" ["+info+"]",(float)rects.get(2).left,rects.get(2).centerY(),Fonts.FONT);
        //canvas.drawText(info,(float)rects.get(3).left,rects.get(3).centerY(),Fonts.FONT);

/*
        int fk = innerContent.width() / 25;

        Rect topCorner = new Rect(innerContent.left + fk, innerContent.top, innerContent.right - fk, innerContent.top + fk / 4);

        Path corner = new Path();
        corner.moveTo(topCorner.left, topCorner.top);
        corner.lineTo(topCorner.right, topCorner.top);
        corner.lineTo(topCorner.right - fk / 2, topCorner.bottom);
        corner.lineTo(topCorner.left + fk / 2, topCorner.bottom);
        corner.lineTo(topCorner.left, topCorner.top);
        corner.close();
        canvas.drawPath(corner, filler2);
        canvas.drawPath(corner, Colors.backPainterLine2);

        topCorner = new Rect(innerContent.left + fk, innerContent.bottom-fk / 4, innerContent.right - fk, innerContent.bottom);

        corner = new Path();
        corner.moveTo(topCorner.left, topCorner.bottom);
        corner.lineTo(topCorner.right, topCorner.bottom);
        corner.lineTo(topCorner.right - fk / 2, topCorner.top);
        corner.lineTo(topCorner.left + fk / 2, topCorner.top);
        corner.lineTo(topCorner.left, topCorner.bottom);
        corner.close();
        canvas.drawPath(corner, filler2);
        canvas.drawPath(corner, Colors.backPainterLine2);
*/

        canvas.drawRect(innerContent, Colors.backPainterLine2);


    }
}
