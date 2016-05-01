package games.biitworx.starcitysim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.views.MenuWindow;

/**
 * Created by marce_000 on 29.04.2016.
 */
public class GameViewBackNormal extends View {
    public GameViewBackNormal(Context context) {
        super(context);
    }

    private Window view = new MenuWindow();

    public GameViewBackNormal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Window getWindow() {
        return view;
    }


    public void changeWindow(Window window) {
        view = window;
    }

    @Override
    public void onDraw(Canvas canvas) {

        Paint backer = new Paint();

        backer.setAntiAlias(true);
        backer .setStyle(Paint.Style.FILL);
        backer.setColor(Color.argb(100, 30, 60, 60));

        Colors.outlinePainter3.setShader(new RadialGradient(canvas.getClipBounds().exactCenterX(),
                canvas.getClipBounds().exactCenterY(), canvas.getWidth() / 2,
                Color.argb(200, 15, 130, 160), Colors.outlineFillColor3, Shader.TileMode.CLAMP));
        Rect content = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        Rect topper = new Rect(content.left, content.top, content.right, content.height() / 10);
        Rect botter = new Rect(content.left, content.bottom - content.height() / 10, content.right, content.bottom);



        canvas.drawRect(content,backer);
        canvas.drawRect(content,Colors.backPainterContentShader);


        Rect borderRect = new Rect(topper.left, topper.bottom, topper.right, topper.bottom + 2);
        Rect borderRect2 = new Rect(botter.left, botter.top - 2, botter.right, botter.top);



        MenuRects.content = new RectContainer(content);
        int w = 10;
        MenuRects.contentInner = new RectContainer(new Rect(content.left+ (content.width() / 50)/4, topper.bottom, content.right - content.width() / 50, botter.top));

        Rect liner = new Rect(topper.left + w, topper.top + w, topper.right - content.width() / 50, topper.bottom - w);
        MenuRects.line = new RectContainer(new Rect(liner.left, liner.top, liner.right, (int) (liner.height() / 1.9)));


        //canvas.drawRect(new Rect(content.left, topper.bottom, content.right, botter.top), Colors.backPainterContentShader);
        canvas.drawRect(new Rect(content.left, topper.bottom, content.right, botter.top), Colors.backPainterContent);

        canvas.drawRect(new Rect(content.left, topper.bottom, content.right, botter.top), Colors.backPainterContentShader2);
        canvas.drawRect(new Rect(content.left, topper.bottom, content.right, botter.top), Colors.outlinePainter3);
        //canvas.drawRect(new Rect(content.left, topper.bottom, content.right, botter.top), Colors.backPainterLine2);


        MenuRects.icon = new RectContainer(topper);

        MenuRects.info = new RectContainer(topper);
        if (view != null) {
            view.scroller = false;
            if (view.getMaxScrollPosition() - MenuRects.contentInner.get().height() > 0)
                view.scroller = true;
        }
        view.onDraw(canvas);

int color2=Color.argb(255, 0, 100, 130);
        RectHelper.drawRectGradient(borderRect,Color.argb(255,0,0,0),color2,canvas);
        RectHelper.drawRectGradient(borderRect2,Color.argb(255,0,0,0),color2,canvas);
        RectHelper.drawRectGradient(new Rect(borderRect.left,borderRect.top-MenuRects.info.get().height()/2,borderRect.right,borderRect.bottom-MenuRects.info.get().height()/2),Color.argb(255,0,0,0),color2,canvas);

        canvas.drawRect(content, Colors.backPainterLine3);



    }
}
