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

import java.util.ArrayList;

import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.views.MenuOverlayWindow;
import games.biitworx.starcitysim.window.views.MenuWindow;

/**
 * Created by marce_000 on 29.04.2016.
 */
public class GameViewBackNormal extends View {
    public GameViewBackNormal(Context context) {
        super(context);
    }

    private Window view = new MenuWindow();
    private Window overlay = new MenuOverlayWindow();

    private boolean showOverlay = false;

    public GameViewBackNormal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Window getWindow() {
        return view;
    }

    public Window getOverlayWindow() {
        if(view==null)return overlay;
        return view.getOverlayWindow()!=null?view.getOverlayWindow(): overlay;
    }

    public void changeWindow(Window window) {
        view = window;
    }

    public void changeOverlayWindow(Window window) {
        overlay = window;
    }

    public void setOverlaySetting(boolean show) {
        showOverlay = show;
    }

    public boolean getOverlaySetting() {
        return showOverlay;
    }

    @Override
    public void onDraw(Canvas canvas) {

        Paint backer = new Paint();

        backer.setAntiAlias(true);
        backer.setStyle(Paint.Style.FILL);
        backer.setColor(Color.argb(100, 30, 60, 60));
        RadialGradient shader1 = new RadialGradient(canvas.getClipBounds().exactCenterX(),
                canvas.getClipBounds().exactCenterY(), (int) (canvas.getWidth() / 1.05),
                Color.argb(75, 15, 130, 160), Color.argb(100, 30, 60, 60), Shader.TileMode.CLAMP);

        Colors.outlinePainter3.setShader(shader1);
        Rect content = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        Rect topper = new Rect(content.left, content.top, content.right, content.height() / 10);
        Rect botter = new Rect(content.left, content.bottom - content.height() / 10, content.right, content.bottom);

        MenuRects.notification = new RectContainer(botter);

        canvas.drawRect(content, backer);
        canvas.drawRect(topper, Colors.backPainterContentShader3);
        canvas.drawRect(botter, Colors.backPainterContentShader3);


        Rect borderRect = new Rect(topper.left, topper.bottom, topper.right, topper.bottom + 2);
        Rect borderRect2 = new Rect(botter.left, botter.top - 2, botter.right, botter.top);


        MenuRects.content = new RectContainer(content);
        int w = 10;
        MenuRects.contentInner = new RectContainer(new Rect(content.left + (content.width() / 50) / 4, topper.bottom, content.right - content.width() / 50, botter.top));

        Rect liner = new Rect(topper.left + w, topper.top + w, topper.right - content.width() / 50, topper.bottom - w);
        MenuRects.line = new RectContainer(new Rect(liner.left, liner.top, liner.right, (int) (liner.height() / 2)));


        canvas.drawRect(new Rect(content.left, topper.bottom, content.right, botter.top), Colors.backPainterContent);


        canvas.drawRect(new Rect(content.left, topper.bottom, content.right, botter.top), Colors.outlinePainter3);
        canvas.drawRect(new Rect(content.left, topper.bottom, content.right, botter.top), Colors.backPainterContentShader3);
        RadialGradient shader2 = new RadialGradient(botter.exactCenterX(),
                botter.exactCenterY(), canvas.getWidth() / 2,
                Color.argb(75, 15, 130, 160), Colors.outlineFillColor3, Shader.TileMode.CLAMP);

        Colors.outlinePainter3.setShader(shader2);
        canvas.drawRect(botter, Colors.outlinePainter3);
        RadialGradient shader3 = new RadialGradient(topper.exactCenterX(),
                topper.exactCenterY(), canvas.getWidth() / 2,
                Color.argb(75, 15, 130, 160), Colors.outlineFillColor3, Shader.TileMode.CLAMP);

        Colors.outlinePainter3.setShader(shader3);
        canvas.drawRect(topper, Colors.outlinePainter3);

        RadialGradient shader4 = new RadialGradient(content.exactCenterX(),
                content.exactCenterY(), canvas.getWidth() / 2,
                Color.argb(75, 15, 130, 160), Colors.outlineFillColor3, Shader.TileMode.CLAMP);

        Colors.outlinePainter3.setShader(shader4);

        canvas.drawRect(content, Colors.outlinePainter3);

        int color2 = Color.argb(255, 0, 100, 130);

        MenuRects.icon = new RectContainer(topper);
        int color3 = Color.argb(35, 0, 100, 130);


        MenuRects.info = new RectContainer(topper);
        Rect borderRect3 = new Rect(borderRect.left, borderRect.top - MenuRects.info.get().height() / 2, borderRect.right, borderRect.bottom - MenuRects.info.get().height() / 2);
        Rect texter = new Rect(borderRect3.left, borderRect3.top, borderRect3.right, borderRect.top);
        RectHelper.drawRectGradient(texter, Color.argb(50, 0, 0, 0), color3, canvas);
        if (showOverlay == false) {
            if (view != null) {
                view.scroller = false;
                if (view.getMaxScrollPosition() - MenuRects.contentInner.get().height() > 0)
                    view.scroller = true;
            }
            if (view != null)
                view.onDraw(canvas, true);
        } else {
            if (overlay != null) {
                overlay.scroller = false;
                if (overlay.getMaxScrollPosition() - MenuRects.contentInner.get().height() > 0)
                    overlay.scroller = true;
            }

            if (view != null)
                view.onDraw(canvas, false);
            canvas.drawRect(MenuRects.contentInner.get(), Colors.backPainterContent);

            Colors.outlinePainter3.setShader(shader1);
            canvas.drawRect(MenuRects.contentInner.get(), Colors.outlinePainter3);
            canvas.drawRect(MenuRects.contentInner.get(), Colors.backPainterContentShader3);
            if (view != null && view.getOverlayWindow() != null) {
                if (view.getOverlayWindow() != null)
                    view.getOverlayWindow().onDraw(canvas, true);
            } else {
                if (overlay != null)
                    overlay.onDraw(canvas, true);
            }

        }

        RectHelper.drawRectGradient(borderRect, Color.argb(255, 0, 0, 0), color2, canvas);
        RectHelper.drawRectGradient(borderRect2, Color.argb(255, 0, 0, 0), color2, canvas);
        RectHelper.drawRectGradient(borderRect3, Color.argb(255, 0, 0, 0), color2, canvas);

        canvas.drawRect(content, Colors.backPainterLine3);

        RectHelper.drawRectGradient(new Rect(content.left, content.top, content.right, content.top + 2), Color.argb(128, 0, 100, 130), color2, canvas);

        RectHelper.drawRectGradient(new Rect(content.left, content.bottom - 2, content.right, content.bottom), Color.argb(128, 0, 50, 65), color2, canvas);
        float x = botter.centerX();
        float y = botter.centerY();

        y += botter.height() / 8;
        int color4 = Color.argb(MenuWatcher.ALPHA, 15, 100, 130);

        if (showOverlay)
            color4 = Color.argb(MenuWatcher.ALPHA, 15, 130, 100);
        RadialGradient shader5 = new RadialGradient(x,
                y, (int) (botter.height() / 3.5f),
                color4, Color.argb(75, 0, 0, 0), Shader.TileMode.CLAMP);
        Colors.outlinePainter3.setShader(shader5);

        MenuRects.menu = new RectContainer(botter, new Runnable() {
            @Override
            public void run() {
                if (!showOverlay) {
                    showOverlay = true;
                } else {
                    showOverlay = false;
                }
                Game.updateEx();
            }
        });


        canvas.drawArc(x - botter.height() / 3.25f, y - botter.height() / 3.25f, x + botter.height() / 3.25f, y + botter.height() / 3.25f, 0, 360, true, Colors.outlinePainter3);
        canvas.drawArc(x - botter.height() / 3.25f, y - botter.height() / 3.25f, x + botter.height() / 3.25f, y + botter.height() / 3.25f, 0, 360, true, showOverlay? Colors.backPainterLine2:Colors.backPainterLine3);

        canvas.drawArc(x - botter.height() / 3.5f, y - botter.height() / 3.5f, x + botter.height() / 3.5f, y + botter.height() / 3.5f, 0, 360, true, Colors.outlinePainter3);
        canvas.drawArc(x - botter.height() / 3.5f, y - botter.height() / 3.5f, x + botter.height() / 3.5f, y + botter.height() / 3.5f, 0, 360, true, showOverlay? Colors.backPainterLine2:Colors.backPainterLine3);

        Colors.outlinePainter2.setColor(Color.argb(255, 15, 70, 90));
        if (showOverlay)
            Colors.outlinePainter2.setColor(Color.argb(255, 15, 90, 70));

        canvas.drawArc(x - botter.height() / 6.5f, y - botter.height() / 6.5f, x + botter.height() / 6.5f, y + botter.height() / 6.5f, MenuWatcher.START_MENU_0, !showOverlay ? MenuWatcher.END_MENU_0 : MenuWatcher.END_MENU_1, true, Colors.outlinePainter2);

        canvas.drawArc(x - botter.height() / 6.5f, y - botter.height() / 6.5f, x + botter.height() / 6.5f, y + botter.height() / 6.5f, MenuWatcher.START_MENU_0, !showOverlay ? MenuWatcher.END_MENU_0 : MenuWatcher.END_MENU_1, true, Colors.backPainterLine2);


        canvas.drawArc(x - botter.height() / 12.5f, y - botter.height() / 12.5f, x + botter.height() / 12.5f, y + botter.height() / 12.5f, MenuWatcher.START_MENU_1, !showOverlay ? MenuWatcher.END_MENU_1 : MenuWatcher.END_MENU_0, true, Colors.outlinePainter2);

        canvas.drawArc(x - botter.height() / 12.5f, y - botter.height() / 12.5f, x + botter.height() / 12.5f, y + botter.height() / 12.5f, MenuWatcher.START_MENU_1, !showOverlay ? MenuWatcher.END_MENU_1 : MenuWatcher.END_MENU_0, true, Colors.backPainterLine2);

        canvas.drawArc(x - botter.height() / 8.5f, y - botter.height() / 8.5f, x + botter.height() / 8.5f, y + botter.height() / 8.5f, MenuWatcher.START_MENU_2, !showOverlay ? MenuWatcher.END_MENU_2 : MenuWatcher.END_MENU_3, true, Colors.outlinePainter2);

        canvas.drawArc(x - botter.height() / 8.5f, y - botter.height() / 8.5f, x + botter.height() / 8.5f, y + botter.height() / 8.5f, MenuWatcher.START_MENU_2, !showOverlay ? MenuWatcher.END_MENU_2 : MenuWatcher.END_MENU_3, true, Colors.backPainterLine2);

        canvas.drawArc(x - botter.height() / 15.5f, y - botter.height() / 15.5f, x + botter.height() / 15.5f, y + botter.height() / 15.5f, MenuWatcher.START_MENU_3, !showOverlay ? MenuWatcher.END_MENU_3 : MenuWatcher.END_MENU_2, true, Colors.outlinePainter2);

        canvas.drawArc(x - botter.height() / 15.5f, y - botter.height() / 15.5f, x + botter.height() / 15.5f, y + botter.height() / 15.5f, MenuWatcher.START_MENU_3, !showOverlay ? MenuWatcher.END_MENU_3 : MenuWatcher.END_MENU_2, true, Colors.backPainterLine2);

    }
}
