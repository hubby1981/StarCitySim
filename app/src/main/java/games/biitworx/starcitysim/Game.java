package games.biitworx.starcitysim;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import java.util.Timer;
import java.util.TimerTask;

import games.biitworx.starcitysim.window.Window;

public class Game extends AppCompatActivity {

    private static Runnable update;
    private static Runnable timer;

    private static int ScrollPosition = 0;
    private int OldY = 0;
    private boolean touch = false;
    private boolean scrolled = false;


    private static GameViewBackNormal view;


    public static Resources res;
    public static int counter = 16;

    public static int DAY=1;
    public static int MONTH=1;
    public static int YEAR=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        res = getResources();


        Colors.shaderBack = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.back), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        Colors.shaderBack2 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.back_shader), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        Colors.backPainterContentShader.setStyle(Paint.Style.FILL);
        Colors.backPainterContentShader.setShader(Colors.shaderBack);

        Colors.backPainterContentShader2.setStyle(Paint.Style.FILL);
        Colors.backPainterContentShader2.setShader(Colors.shaderBack2);

        Fonts.FONT.setTypeface(Typeface.createFromAsset(getAssets(), "venus.ttf"));
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

        timer = new Runnable() {
            @Override
            public void run() {
                int  speed=18000;
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        counter--;
                        if (counter== 0) {
                            counter = 16;
                            DAY++;

                            if(DAY==20){
                                DAY=1;
                                MONTH++;
                            }
                            if(MONTH==10){
                                YEAR++;
                                MONTH=1;
                            }
                        }


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                update();
                            }
                        });
                    }
                }, speed,speed);
            }
        };
        //timer.run();
        runOnUiThread(update);


    }

    public void update() {
        update.run();
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
                    int max = view.getWindow().getMaxScrollPosition() - MenuRects.contentInner.get().height();
                    max += MenuRects.line.get().height();
                    view.getWindow().down = true;
                    if (newScroller < max) {

                        scrolled = true;
                        ScrollPosition = newScroller;
                        update.run();

                    } else {
                        view.getWindow().down = false;
                        update.run();
                    }
                }
            }

        }

        if (event.getAction() == MotionEvent.ACTION_UP) {
            touch = false;

            if (!scrolled) {
                //MenuRects.testHit((int) event.getX(), (int) event.getY() - (MenuRects.icon.get().top));

                if (view != null && view.getWindow() != null && MenuRects.contentInner.get().contains((int)event.getX(),(int)event.getY())) {
                    view.getWindow().checkHit((int) event.getX(), (int) event.getY() - (int)(MenuRects.icon.get().height()*1.5));
                }
            }
            scrolled = false;
        }

        return true;
    }


}
