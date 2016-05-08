package games.biitworx.starcitysim.window.content;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;

import java.util.ArrayList;
import java.util.List;

import games.biitworx.starcitysim.BitmapDrawer;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Fonts;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.RectHelper;
import games.biitworx.starcitysim.T;

/**
 * Created by marcel.weissgerber on 26.04.2016.
 */
public class ComboboxContent extends Content {
    private int color;
    private String primary;
    private String secondary;
    private boolean show = false;
    private List<Content> contents = new ArrayList<>();
    private String value= T.get(R.string.selection_default);

    public ComboboxContent(String primary, String secondary, int color, List<Content> contents) {
        this(primary, secondary, color, null, contents);
    }

    @Override
    public String getValue(){
        return value;
    }

    public ComboboxContent(String primary, String secondary, int color, Runnable action, List<Content> contents) {
        super(2);
        if (contents == null) {
            this.contents = new ArrayList<>();
        } else {
            this.contents = contents;
        }

        this.primary = primary;
        this.secondary = secondary;

        this.color = color;
        if (action == null) {
            action = new Runnable() {
                @Override
                public void run() {
                    show = !show;
                    Game.updateEx(0);
                }
            };
        }

        for (final Content c: contents)
        if(c!=null)
            c.setAction(new Runnable() {
                @Override
                public void run() {
                    value=c.getValue();
                    show = !show;
                    Game.updateEx(0);
                }
            });
        setAction(action);
    }

    @Override
    public int getLineHeight() {
        return show ? super.getLineHeight() + getContentsLineHeight() : super.getLineHeight();
    }

    private int getContentsLineHeight() {
        int result = 0;
        for (Content c : contents)
            result += c.getLineHeight();
        return result;
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


        ArrayList<Rect> rects = RectHelper.makeRects2(innerContent, 6);

        Rect text = RectHelper.combine(rects, 1, 3);


        rects = RectHelper.makeRects2(innerContent, 20);
        text = RectHelper.combine(rects, 1, 14);

        Rect rc1 = new Rect(rects.get(0).left, innerContent.top, rects.get(0).left + rects.get(0).width() / 4, innerContent.bottom);

        Rect rc2 = RectHelper.combine(rects,37,38);

        Path p = new Path();

        int yy= rc2.centerY()+rc2.height()/4;
        p.moveTo(rc2.centerX()-rc2.width()/2,yy);
        p.lineTo(rc2.centerX() + rc2.width() / 2, yy);
        p.lineTo(rc2.centerX(), yy + (int)(rc2.height()/1.25));

        p.lineTo(rc2.centerX() - rc2.width() / 2,yy);
        p.close();
        canvas.drawPath(p, Colors.topOutlinePainter);
        if(!show)
            canvas.drawPath(p, Colors.backPainterContent);
        canvas.drawPath(p, Colors.backPainterLine2);

        Fonts.FONT.setTextSize((getContentRect().height() / 4));

        rects = RectHelper.makeRect3(text, (int) Fonts.FONT.getTextSize(), 2, 2);


        canvas.drawText(primary, (float) rects.get(1).left, rects.get(1).centerY(), Fonts.FONT);
        Fonts.FONT.setTextSize((getContentRect().height() / 7));
        canvas.drawText(getValue(), (float) rects.get(1).left, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 1.8), Fonts.FONT);


        canvas.drawRect(getInnerFullRect(), Colors.backPainterLine2);
        canvas.drawRect(innerContent, Colors.backPainterLine2);

        if (show) {

            for (Content c : contents)
                c.onDrawEx(canvas);
        }


    }

    @Override
    protected void onDrawContents(int yPos,int scroll){

        for(Content c : contents){
            if(c!=null)
                yPos = c.onDrawInner(yPos,scroll);
        }
    }

    @Override
    public boolean checkHit(int x,int y){
        for (Content c : contents) {
            if (c.hasAction() && c.isHit(x, y)) {
                c.getAction().run();
                return true;
            }
        }
        return false;
    }
}
