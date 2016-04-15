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

    private int inlineFaktor = 20;

    public GameViewBackNormal(Context context) {
        super(context);
    }


    @Override
    public void onDraw(Canvas canvas) {

        outlineRect(canvas);
        inlineRect(canvas);

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


    private void outlineTriangle(Canvas canvas){
        int fak = canvas.getWidth() / inlineFaktor;
        Path left = new Path();

        int x = outline.left;
        int y = outline.top;
        int xx = outline.right;
        int yy = outline.bottom;

        int fakInner= fak;


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

        x = outline.left;


        Path top = new Path();


        top.moveTo(x + fak * 4, y);
        top.lineTo(xx - fak * 4, y);
        top.lineTo((xx - fak * 4) - fak / 2, y + fak / 2);
        top.lineTo((x + fak * 4) + fak / 2, y + fak / 2);
        top.lineTo(x + fak * 4, y);

        canvas.drawPath(top, Colors.backPainter);
        canvas.drawPath(top, Colors.backPainterLine);

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
        rightDown.lineTo(xx- fak / 2, (yy - fak * 4) - fak / 2);
        rightDown.lineTo(xx, yy - fak * 4);
        rightDown.lineTo(xx, y + fak * 4);

        canvas.drawPath(rightDown, Colors.backPainter);
        canvas.drawPath(rightDown, Colors.backPainterLine);

        Rect topInner=new Rect(x+fak*6,y+fak/2,xx-fak*6,y+fak);
        canvas.drawRect(topInner, Colors.topOutlinePainter);

        Rect leftInner=new Rect(x+fak/2,y+fak*6,x+fak,yy-fak*6);
        canvas.drawRect(leftInner,Colors.topOutlinePainter);

        Rect rightInner=new Rect(xx-fak,y+fak*6,xx-fak/2,yy-fak*6);
        canvas.drawRect(rightInner,Colors.topOutlinePainter);

        Rect bottomInner=new Rect(x+fak*6,yy-fak,xx-fak*6,yy-fak/2);
        canvas.drawRect(bottomInner, Colors.topOutlinePainter);

    }


}
