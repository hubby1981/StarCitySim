package games.biitworx.starcitysim.window.content;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;

import java.util.ArrayList;
import java.util.List;

import games.biitworx.starcitysim.BitmapDrawer;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Fonts;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.RectHelper;

/**
 * Created by marcel.weissgerber on 26.04.2016.
 */
public class ComboboxContent extends Content {
    private int color;
    private String primary;
    private String secondary;
    private boolean show = false;
    private List<Content> contents = new ArrayList<>();

    public ComboboxContent(String primary, String secondary, int color, List<Content> contents) {
        this(primary, secondary, color, null, contents);
    }

    public ComboboxContent(String primary, String secondary, int color, Runnable action, List<Content> contents) {
        super(2);
        if (contents == null) {
            this.contents = new ArrayList<>();
        }else{
            this.contents=contents;
        }

        this.primary = primary;
        this.secondary = secondary;

        this.color = color;
        if (action == null) {
            action = new Runnable() {
                @Override
                public void run() {
                    show = !show;
                    Game.updateEx();
                }
            };
        }
        setAction(action);
    }

    @Override
    public int getLineHeight() {
        return show ? super.getLineHeight() +getContentsLineHeight() : super.getLineHeight();
    }

    private int getContentsLineHeight(){
        int result =0;
        for(Content c : contents)
            result+=c.getLineHeight();
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


        Fonts.FONT.setTextSize((getContentRect().height() / 5));

        rects = RectHelper.makeRect3(text, (int) Fonts.FONT.getTextSize(), 2, 2);


        canvas.drawText(primary, (float) rects.get(1).left, rects.get(1).centerY(), Fonts.FONT);
        Fonts.FONT.setTextSize((getContentRect().height() / 9));
        canvas.drawText(secondary, (float) rects.get(1).left, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 1.8), Fonts.FONT);


        canvas.drawRect(getInnerFullRect(), Colors.backPainterLine2);
        canvas.drawRect(innerContent, Colors.backPainterLine2);




    }
}
