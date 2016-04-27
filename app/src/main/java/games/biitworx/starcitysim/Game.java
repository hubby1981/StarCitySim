package games.biitworx.starcitysim;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import games.biitworx.starcitysim.window.Window;

public class Game extends AppCompatActivity {

    private static Runnable update;
    private static int ScrollPosition = 0;
    private int OldY = 0;
    private boolean touch = false;
    private boolean scrolled = false;

    public static Bitmap IMG1;
    public static Bitmap IMG2;
    public static Bitmap IMG3;
    private static GameViewBackNormal view;


    public static Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        res = getResources();
        IMG1 = BitmapFactory.decodeResource(getResources(), R.drawable.button);
        IMG2 = BitmapFactory.decodeResource(getResources(), R.drawable.panel);
        IMG3 = BitmapFactory.decodeResource(getResources(), R.drawable.panel2);


        Colors.shaderBack = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.back), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        Colors.shaderBack2 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.back_shader), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        Colors.backPainterContentShader.setStyle(Paint.Style.FILL);
        Colors.backPainterContentShader.setShader(Colors.shaderBack);

        Colors.backPainterContentShader2.setStyle(Paint.Style.FILL);
        Colors.backPainterContentShader2.setShader(Colors.shaderBack2);
        setContentView(R.layout.activity_game);
        view = (GameViewBackNormal) findViewById(R.id.gameback);
        ScrollPosition = view.getWindow().getScrollPosition();

        update = new Runnable() {
            @Override
            public void run() {

                if (view != null && view.getWindow() != null) {

                    view.getWindow().setScrollPosition(ScrollPosition);

                    view.invalidate();
                }
            }
        };
    }


    public static void changeWindow(Window window) {
        if (view != null) {
            view.changeWindow(window);
            ScrollPosition = view.getWindow().getScrollPosition();

        }
        update.run();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            scrolled = false;
            OldY = (int) event.getY();
            touch = true;
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE && touch) {
            int scroller = ((int) event.getY()) - OldY;
            if (scroller > 10 || scroller < -10) {
                int newScroller = ScrollPosition;


                newScroller -= scroller / 8;
                if (newScroller < 0)
                    newScroller = 0;
                touch = true;

                if (view != null && view.getWindow() != null && newScroller != 0) {
                    int max = view.getWindow().getMaxScrollPosition() - MenuRects.content.get().height();
                    max += MenuRects.line.get().height();
                    if (newScroller < max) {
                        scrolled = true;
                        ScrollPosition = newScroller;
                        update.run();

                    }
                }
            }

        }

        if (event.getAction() == MotionEvent.ACTION_UP) {
            touch = false;

            if (!scrolled) {
                MenuRects.testHit((int) event.getX(), (int) event.getY() - (MenuRects.icon.get().top));

                if (view != null && view.getWindow() != null) {
                    view.getWindow().checkHit((int) event.getX(), (int) event.getY() - (MenuRects.icon.get().top * 4));
                }
            }
            scrolled = false;
        }

        return true;
    }


}
