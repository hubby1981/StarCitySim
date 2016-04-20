package games.biitworx.starcitysim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by marcel.weissgerber on 15.04.2016.
 */
public class GameViewBackNormal extends View {
    private Rect outline;
    private Rect inline;
    private Rect filler;
    private final float reduce = 1.6f;
    private int inlineFaktor = 20;
    private Rect content;
    private Rect contentInner;

    public GameViewBackNormal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onDraw(Canvas canvas) {

        Colors.outlinePainter3.setShader(new RadialGradient(canvas.getClipBounds().exactCenterX(),
                canvas.getClipBounds().exactCenterY(), canvas.getWidth() / 2,
                Color.argb(75, 15, 130, 160), Colors.outlineFillColor3, Shader.TileMode.CLAMP));

        outlineRect(canvas);
        inlineRect(canvas);
        fillerRect(canvas);
        outlineTriangle(canvas);

        int fakW = canvas.getWidth() / inlineFaktor;
        fakW = (int) (fakW / reduce / 2);
        ArrayList<Rect> menu = makeRects(new Rect(filler.left, filler.top, filler.right, filler.bottom + fakW), 6);


        content = RectHelper.combine(menu, 0, menu.size() - 1);


        canvas.drawRect(content, Colors.backPainterContentShader2);

        canvas.drawRect(content, Colors.outlinePainter3);

        // canvas.drawRect(content, Colors.backPainterLine2);

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.button);
        Bitmap b1 = BitmapFactory.decodeResource(getResources(), R.drawable.panel);
        Bitmap b2 = BitmapFactory.decodeResource(getResources(), R.drawable.panel2);

        content = new Rect(content.left + fakW, content.top + fakW, content.right - fakW, content.bottom - fakW);

        menu = makeRects2(content, 6);


        MenuRects.menu =new RectContainer( menu.get(0));
        MenuRects.icon = new RectContainer( menu.get(10));

        MenuRects.info = new RectContainer( RectHelper.combine(menu, 2, 8));


        canvas.drawBitmap(b, new Rect(0, 0, b.getWidth(), b.getHeight()), MenuRects.menu.get(), null);
        canvas.drawBitmap(b, new Rect(0, 0, b.getWidth(), b.getHeight()), MenuRects.icon.get(), null);

        canvas.drawBitmap(b1, new Rect(0, 0, b1.getWidth(), b1.getHeight()),MenuRects.info.get(), null);


        ArrayList<Rect> items = makeRect3(content, menu.get(0).height(), menu.get(1).width(),1);

        menu = makeRects2(items.get(items.size() - 1), 6);

        MenuRects.action1 =new RectContainer( menu.get(0));
        MenuRects.action2 =new RectContainer( menu.get(2));
        MenuRects.action3 =new RectContainer( menu.get(4));
        MenuRects.action4 =new RectContainer( menu.get(6));
        MenuRects.action5 =new RectContainer( menu.get(8));
        MenuRects.action6 =new RectContainer( menu.get(10));

        canvas.drawBitmap(b, new Rect(0, 0, b.getWidth(), b.getHeight()),MenuRects.action1.get(), null);
        canvas.drawBitmap(b, new Rect(0, 0, b.getWidth(), b.getHeight()),MenuRects.action2.get(), null);
        canvas.drawBitmap(b, new Rect(0, 0, b.getWidth(), b.getHeight()),MenuRects.action3.get(), null);
        canvas.drawBitmap(b, new Rect(0, 0, b.getWidth(), b.getHeight()),MenuRects.action4.get(), null);
        canvas.drawBitmap(b, new Rect(0, 0, b.getWidth(), b.getHeight()),MenuRects.action5.get(), null);
        canvas.drawBitmap(b, new Rect(0, 0, b.getWidth(), b.getHeight()),MenuRects.action6.get(), null);


        contentInner = RectHelper.combine(items, 1, items.size() - 2);
        MenuRects.content = new RectContainer( contentInner);
        MenuRects.contentInner = new RectContainer( new Rect(contentInner.left+fakW,contentInner.top+fakW,contentInner.right-fakW,contentInner.bottom-fakW));

        canvas.drawBitmap(b2, new Rect(0, 0, b2.getWidth(), b2.getHeight()), MenuRects.content.get(), null);

        items = makeRect3(MenuRects.contentInner.get(),MenuRects.action1.get().height()/2,0,1);
        Paint font = new Paint();

        font.setColor(Color.argb(255, 255, 255, 255));
        font.setFakeBoldText(true);
        font.setAntiAlias(true);
        int index=1;
        for(Rect r : items){
            //canvas.drawRect(r, Colors.backPainterLine2);
            font.setTextSize((int) (r.height() / 2));
            canvas.drawText("PANEL "+index,r.left,r.centerY(),font);
            index++;
        }


    }

    private void outlineRect(Canvas canvas) {
        outline = new Rect(0, 0, canvas.getWidth(), getHeight());

        canvas.drawRect(outline, Colors.outlinePainter);


    }

    private void inlineRect(Canvas canvas) {
        int fak = canvas.getWidth() / inlineFaktor;
        fak = (int) (fak / reduce);
        inline = new Rect(0 + fak, 0 + fak, canvas.getWidth() - fak, getHeight() - fak);


        canvas.drawRect(inline, Colors.inlinePainter);


    }

    private void fillerRect(Canvas canvas) {
        int fak = canvas.getWidth() / inlineFaktor * 2;
        fak = (int) (fak / reduce);
        filler = new Rect(0 + fak, 0 + fak, canvas.getWidth() - fak, canvas.getHeight() - fak);
        canvas.drawRect(filler, Colors.backLinePainterContent);
/*
        filler = new Rect(0 + fak, (0 + fak * 3), (0 + (fak)) + fak / 8, (canvas.getHeight() - fak * 3));
        canvas.drawRect(filler, Colors.outlinePainter2);
        canvas.drawRect(filler, Colors.backPainterLine);

        filler = new Rect((canvas.getWidth() - (fak)) - fak / 8, (0 + fak * 3), (canvas.getWidth() - (fak)), (canvas.getHeight() - fak * 3));
        canvas.drawRect(filler, Colors.outlinePainter2);
        canvas.drawRect(filler, Colors.backPainterLine);

        filler = new Rect(0 + (fak + fak * 2), 0 + fak, canvas.getWidth() - (fak + fak * 2), (0 + fak) + fak / 8);
        canvas.drawRect(filler, Colors.outlinePainter2);
        canvas.drawRect(filler, Colors.backPainterLine);

        filler = new Rect(0 + (fak + fak * 2), (canvas.getHeight() - fak) - fak / 8, canvas.getWidth() - (fak + fak * 2), canvas.getHeight() - fak);
        canvas.drawRect(filler, Colors.outlinePainter2);
        canvas.drawRect(filler, Colors.backPainterLine);*/


        filler = new Rect(0 + fak + fak / 8, 0 + fak + fak / 8, canvas.getWidth() - (fak + fak / 8), getHeight() - (fak + fak / 8));


        canvas.drawRect(filler, Colors.backPainterContentShader);
        canvas.drawRect(filler, Colors.backPainterContent);


        int x = filler.left;
        int y = filler.top;
        int xx = filler.right;
        int yy = filler.bottom;
        Path left = new Path();
        int fakInner = fak / 8;
        left.moveTo(x, y);
        left.lineTo(x + fakInner, y);
        left.lineTo(x, y + fakInner);
        left.lineTo(x, y);
        left.close();
        canvas.drawPath(left, Colors.backLinePainterContent);
        Path right = new Path();

        right.moveTo(xx, y);
        right.lineTo(xx - fakInner, y);
        right.lineTo(xx, y + fakInner);
        right.lineTo(xx, y);
        right.close();
        canvas.drawPath(right, Colors.backLinePainterContent);
        Path rightBottom = new Path();

        rightBottom.moveTo(xx, yy);
        rightBottom.lineTo(xx - fakInner, yy);
        rightBottom.lineTo(xx, yy - fakInner);
        rightBottom.lineTo(xx, yy);
        rightBottom.close();
        canvas.drawPath(rightBottom, Colors.backLinePainterContent);
        Path leftBottom = new Path();

        leftBottom.moveTo(x, yy);
        leftBottom.lineTo(x + fakInner, yy);
        leftBottom.lineTo(x, yy - fakInner);
        leftBottom.lineTo(x, yy);
        leftBottom.close();
        canvas.drawPath(leftBottom, Colors.backLinePainterContent);

    }


    private void outlineTriangle(Canvas canvas) {
        int fak = canvas.getWidth() / inlineFaktor;
        fak = (int) (fak / reduce);
        Path left = new Path();

        int x = outline.left;
        int y = outline.top;
        int xx = outline.right;
        int yy = outline.bottom;

        int fakInner = fak;


        left.moveTo(x, y);
        left.lineTo(x + fak, y);
        left.lineTo(x, y + fak);
        left.lineTo(x, y);
        left.close();

        canvas.drawPath(left, Colors.backPainter);

        Path left2 = new Path();
        left2.moveTo(x + fakInner, y + fakInner);
        left2.lineTo(x + fakInner * 2, y + fakInner);
        left2.lineTo(x + fakInner, y + fakInner * 2);
        left2.lineTo(x + fakInner, y + fakInner);
        left2.close();
        canvas.drawPath(left2, Colors.outlinePainter);

        int fakInner2 = fakInner + fakInner / 2;
        left2 = new Path();
        left2.moveTo(x + fakInner2, y + fakInner2);
        left2.lineTo(x + fakInner2 * 2, y + fakInner2);
        left2.lineTo(x + fakInner2, y + fakInner2 * 2);
        left2.lineTo(x + fakInner2, y + fakInner2);
        left2.close();
        canvas.drawPath(left2, Colors.inlinePainter);

        left = new Path();
        left.moveTo(x, yy);
        left.lineTo(x + fak, yy);
        left.lineTo(x, yy - fak);
        left.lineTo(x, yy);
        left.close();

        canvas.drawPath(left, Colors.backPainter);

        left2 = new Path();
        left2.moveTo(x + fakInner, yy - fakInner);
        left2.lineTo(x + fakInner * 2, yy - fakInner);
        left2.lineTo(x + fakInner, yy - fakInner * 2);
        left2.lineTo(x + fakInner, yy - fakInner);
        left2.close();
        canvas.drawPath(left2, Colors.outlinePainter);

        left2 = new Path();
        left2.moveTo(x + fakInner2, yy - fakInner2);
        left2.lineTo(x + fakInner2 * 2, yy - fakInner2);
        left2.lineTo(x + fakInner2, yy - fakInner2 * 2);
        left2.lineTo(x + fakInner2, yy - fakInner2);
        left2.close();
        canvas.drawPath(left2, Colors.inlinePainter);

        x = outline.right;


        Path right = new Path();
        right.moveTo(x, y);
        right.lineTo(x - fak, y);
        right.lineTo(x, y + fak);
        right.lineTo(x, y);
        right.close();

        canvas.drawPath(right, Colors.backPainter);

        Path right2 = new Path();
        right2.moveTo(x - fakInner, y + fakInner);
        right2.lineTo(x - fakInner * 2, y + fakInner);
        right2.lineTo(x - fakInner, y + fakInner * 2);
        right2.lineTo(x - fakInner, y + fakInner);
        right2.close();
        canvas.drawPath(right2, Colors.outlinePainter);

        right2 = new Path();
        right2.moveTo(x - fakInner2, y + fakInner2);
        right2.lineTo(x - fakInner2 * 2, y + fakInner2);
        right2.lineTo(x - fakInner2, y + fakInner2 * 2);
        right2.lineTo(x - fakInner2, y + fakInner2);
        right2.close();
        canvas.drawPath(right2, Colors.inlinePainter);

        right = new Path();
        right.moveTo(x, yy);
        right.lineTo(x - fak, yy);
        right.lineTo(x, yy - fak);
        right.lineTo(x, yy);
        right.close();

        canvas.drawPath(right, Colors.backPainter);

        right2 = new Path();
        right2.moveTo(x - fakInner, yy - fakInner);
        right2.lineTo(x - fakInner * 2, yy - fakInner);
        right2.lineTo(x - fakInner, yy - fakInner * 2);
        right2.lineTo(x - fakInner, yy - fakInner);
        right2.close();
        canvas.drawPath(right2, Colors.outlinePainter);

        right2 = new Path();
        right2.moveTo(x - fakInner2, yy - fakInner2);
        right2.lineTo(x - fakInner2 * 2, yy - fakInner2);
        right2.lineTo(x - fakInner2, yy - fakInner2 * 2);
        right2.lineTo(x - fakInner2, yy - fakInner2);
        right2.close();
        canvas.drawPath(right2, Colors.inlinePainter);

        x = outline.left;


        Path top = new Path();


        top.moveTo(x + fak * 4, y);
        top.lineTo(xx - fak * 4, y);
        top.lineTo((xx - fak * 4) - fak / 2, y + fak / 2);
        top.lineTo((x + fak * 4) + fak / 2, y + fak / 2);
        top.lineTo(x + fak * 4, y);

        canvas.drawPath(top, Colors.backPainter);
        canvas.drawPath(top, Colors.backPainterLine);

        Path bottom = new Path();


        bottom.moveTo(x + fak * 4, yy);
        bottom.lineTo(xx - fak * 4, yy);
        bottom.lineTo((xx - fak * 4) - fak / 2, yy - fak / 2);
        bottom.lineTo((x + fak * 4) + fak / 2, yy - fak / 2);
        bottom.lineTo(x + fak * 4, yy);

        canvas.drawPath(bottom, Colors.backPainter);
        canvas.drawPath(bottom, Colors.backPainterLine);

        Path leftDown = new Path();


        leftDown.moveTo(x, y + fak * 4);
        leftDown.lineTo(x + fak / 2, (y + fak * 4) + fak / 2);
        leftDown.lineTo(x + fak / 2, (yy - fak * 4) - fak / 2);
        leftDown.lineTo(x, yy - fak * 4);
        leftDown.lineTo(x, y + fak * 4);

        canvas.drawPath(leftDown, Colors.backPainter);
        canvas.drawPath(leftDown, Colors.backPainterLine);

        Path rightDown = new Path();


        rightDown.moveTo(xx, y + fak * 4);
        rightDown.lineTo(xx - fak / 2, (y + fak * 4) + fak / 2);
        rightDown.lineTo(xx - fak / 2, (yy - fak * 4) - fak / 2);
        rightDown.lineTo(xx, yy - fak * 4);
        rightDown.lineTo(xx, y + fak * 4);

        canvas.drawPath(rightDown, Colors.backPainter);
        canvas.drawPath(rightDown, Colors.backPainterLine);


        Rect topInner = new Rect(x + fak * 6, y + fak / 2, xx - fak * 6, y + fak);
        canvas.drawRect(topInner, Colors.topOutlinePainter);

        Rect leftInner = new Rect(x + fak / 2, y + fak * 6, x + fak, yy - fak * 6);
        canvas.drawRect(leftInner, Colors.topOutlinePainter);

        Rect rightInner = new Rect(xx - fak, y + fak * 6, xx - fak / 2, yy - fak * 6);
        canvas.drawRect(rightInner, Colors.topOutlinePainter);

        Rect bottomInner = new Rect(x + fak * 6, yy - fak, xx - fak * 6, yy - fak / 2);
        canvas.drawRect(bottomInner, Colors.topOutlinePainter);

        Rect topInner2 = new Rect(topInner.left, topInner.bottom - 1, topInner.right, topInner.bottom);
        canvas.drawRect(topInner, Colors.backPainterLine);

        Rect leftInner2 = new Rect(leftInner.right - 1, leftInner.top, leftInner.right, leftInner.bottom);
        canvas.drawRect(leftInner, Colors.backPainterLine);

        Rect rightInner2 = new Rect(rightInner.left, rightInner.top, rightInner.left + 1, rightInner.bottom);
        canvas.drawRect(rightInner, Colors.backPainterLine);

        Rect bottomInner2 = new Rect(bottomInner.left, bottomInner.top - 1, bottomInner.right, bottomInner.top);
        canvas.drawRect(bottomInner, Colors.backPainterLine);


        Path leftOverPanel = new Path();

        leftOverPanel.moveTo(leftInner2.right, leftInner2.top - fak);
        leftOverPanel.lineTo(leftInner2.right + fak / 2, (leftInner2.top - fak) + fak / 2);
        leftOverPanel.lineTo(leftInner2.right + fak / 2, (leftInner2.bottom + fak) - fak / 2);
        leftOverPanel.lineTo(leftInner2.right, leftInner2.bottom + fak);
        leftOverPanel.lineTo(leftInner2.right, leftInner2.top - fak);
        canvas.drawPath(leftOverPanel, Colors.leftOutlinePainter);
        canvas.drawPath(leftOverPanel, Colors.backPainterLine);

        Path rightOverPanel = new Path();

        rightOverPanel.moveTo(rightInner2.left, leftInner2.top - fak);
        rightOverPanel.lineTo(rightInner2.left - fak / 2, (leftInner2.top - fak) + fak / 2);
        rightOverPanel.lineTo(rightInner2.left - fak / 2, (leftInner2.bottom + fak) - fak / 2);
        rightOverPanel.lineTo(rightInner2.left, leftInner2.bottom + fak);
        rightOverPanel.lineTo(rightInner2.left, leftInner2.top - fak);
        canvas.drawPath(rightOverPanel, Colors.leftOutlinePainter);
        canvas.drawPath(rightOverPanel, Colors.backPainterLine);

    }


    private void drawRectOutline(Canvas canvas, Rect bounds, int color1, int color2, int faktor) {
        int fak = bounds.width() / faktor;

        Paint painter1 = new Paint();
        painter1.setStyle(Paint.Style.FILL);
        painter1.setColor(color1);

        Paint painter2 = new Paint();
        painter2.setStyle(Paint.Style.FILL);
        painter2.setColor(color2);


        int x = bounds.left;
        int y = bounds.top;
        int xx = bounds.right;
        int yy = bounds.bottom;


        Path p = new Path();

        p.moveTo(x + fak / 4, y);
        p.lineTo(x + fak * 2, y);
        p.lineTo(x + fak * 2, y + fak / 4);
        x -= fak / 4;

        p.lineTo(x + fak / 2, y + fak / 4);
        p.lineTo(x + fak / 4, y + fak / 2);
        p.lineTo(x + fak / 4, (y + fak * 2) + fak / 4);
        p.lineTo(x, (y + fak * 2) + fak / 4);
        p.lineTo(x, y + fak / 2);

        p.close();

        canvas.drawPath(p, painter1);

        p = new Path();

        p.moveTo(xx - fak / 4, y);
        p.lineTo(xx - fak * 2, y);
        p.lineTo(xx - fak * 2, y + fak / 4);
        xx += fak / 4;

        p.lineTo(xx - fak / 2, y + fak / 4);
        p.lineTo(xx - fak / 4, y + fak / 2);
        p.lineTo(xx - fak / 4, (y + fak * 2) + fak / 4);
        p.lineTo(xx, (y + fak * 2) + fak / 4);
        p.lineTo(xx, y + fak / 2);

        p.close();

        canvas.drawPath(p, painter1);

        p = new Path();

        p.moveTo(xx - fak / 4, yy);
        p.lineTo(xx - fak * 2, yy);
        p.lineTo(xx - fak * 2, yy - fak / 4);
        xx += fak / 4;

        p.lineTo(xx - fak / 2, yy - fak / 4);
        p.lineTo(xx - fak / 4, yy - fak / 2);
        p.lineTo(xx - fak / 4, (yy - fak * 2) - fak / 4);
        p.lineTo(xx, (yy - fak * 2) - fak / 4);
        p.lineTo(xx, yy - fak / 2);

        p.close();

        canvas.drawPath(p, painter1);
    }


    private ArrayList<Rect> makeRects(Rect base, int countW) {
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

    private ArrayList<Rect> makeRects2(Rect base, int countW) {
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

    private ArrayList<Rect> makeRect3(Rect base, int height, int space,int more) {
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


}
