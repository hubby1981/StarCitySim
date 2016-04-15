package games.biitworx.starcitysim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by marcel.weissgerber on 15.04.2016.
 */
public class GameViewBackNormal extends View {
    private Rect outline;
    private Rect inline;
    private Rect filler;

    private int inlineFaktor = 20;

    public GameViewBackNormal(Context context) {
        super(context);
    }


    @Override
    public void onDraw(Canvas canvas) {

        outlineRect(canvas);
        inlineRect(canvas);
        fillerRect(canvas);
        outlineTriangle(canvas);
    }

    private void outlineRect(Canvas canvas) {
        outline = new Rect(0, 0, canvas.getWidth(), getHeight());

        canvas.drawRect(outline, Colors.outlinePainter);


    }

    private void inlineRect(Canvas canvas) {
        int fak = canvas.getWidth() / inlineFaktor;
        inline = new Rect(0 + fak, 0 + fak, canvas.getWidth() - fak, getHeight() - fak);
        canvas.drawRect(inline, Colors.inlinePainter);

    }

    private void fillerRect(Canvas canvas) {
        int fak = canvas.getWidth() / inlineFaktor *2;
        filler = new Rect(0 + fak, 0 + fak, canvas.getWidth() - fak, getHeight() - fak);
        canvas.drawRect(filler, Colors.backPainterContent);

    }


    private void outlineTriangle(Canvas canvas) {
        int fak = canvas.getWidth() / inlineFaktor;
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

        int fakInner2 = fakInner+fakInner/2;
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

    }


}
