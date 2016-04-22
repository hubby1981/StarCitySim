package games.biitworx.starcitysim;

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

public class Game extends AppCompatActivity {

    private Runnable update;
    private int ScrollPosition = 0;
    private int OldY = 0;
    private boolean touch = false;

    public static Bitmap IMG1;
    public static Bitmap IMG2;
    public static Bitmap IMG3;
    private GameViewBackNormal view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


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

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            OldY = (int) event.getY();
            touch = true;
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE && touch) {
            int scroller = ((int) event.getY()) - OldY;
            int newScroller = ScrollPosition;

            newScroller -= scroller / 6;
            if (newScroller < 0)
                newScroller = 0;
            touch = true;

            if (view != null && view.getWindow() != null) {
                int max = view.getWindow().getMaxScrollPosition() - MenuRects.content.get().height();
                max += MenuRects.line.get().height();
                if (newScroller < max) {
                    ScrollPosition = newScroller;
                    update.run();
                }
            }
        }

        if (event.getAction() == MotionEvent.ACTION_UP) {
            touch = false;
        }

        return true;
    }


}
