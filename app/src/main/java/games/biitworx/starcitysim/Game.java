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

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import games.biitworx.starcitysim.window.Window;

public class Game extends AppCompatActivity {

    public static Runnable update;
    private static Runnable timer;

    public static int ScrollPosition = 0;
    private int OldY = 0;
    private boolean touch = false;
    private boolean scrolled = false;


    private static GameViewBackNormal view;


    public static Resources res;
    public static int counter = 16;

    public static int DAY = 1;
    public static int MONTH = 9;
    public static int YEAR = 29391;
    public static int COUNT = 59;
    public static int count = 2;
    public static Runnable notifyAction;

    public static boolean PORTRAIT=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        res = getResources();


        Colors.shaderBack = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.back_shader2), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        Colors.shaderBack2 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.back_shader), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        Colors.shaderBack3 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.back_shader3), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);


        Colors.rock001 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.rock001), Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        Colors.rock002 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.rock002), Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        Colors.rock003 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.rock003), Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        Colors.rock004 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.rock004), Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        Colors.rock005 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.rock005), Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);

        Colors.ice001 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.ice001), Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        Colors.ice002 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.ice002), Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        Colors.ice003 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.ice003), Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        Colors.ice004 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.ice004), Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        Colors.ice005 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.ice005), Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);


        Colors.backPainterContentShader.setStyle(Paint.Style.FILL);
        Colors.backPainterContentShader.setShader(Colors.shaderBack);

        Colors.backPainterContentShader2.setStyle(Paint.Style.FILL);
        Colors.backPainterContentShader2.setShader(Colors.shaderBack2);

        Colors.backPainterContentShader3.setStyle(Paint.Style.FILL);
        Colors.backPainterContentShader3.setShader(Colors.shaderBack3);
//Typeface.createFromAsset(getAssets(), "venus.ttf")
        Fonts.FONT.setTypeface(Typeface.MONOSPACE);
        setContentView(R.layout.activity_game);
        view = (GameViewBackNormal) findViewById(R.id.gameback);
        ScrollPosition = view.getWindow().getScrollPosition();


        update = new Runnable() {
            @Override
            public void run() {
                if (view != null) {
                    Window wnd = !view.getOverlaySetting() ? view.getWindow() : view.getOverlayWindow();

                    if (wnd != null) {

                        wnd.setScrollPosition(ScrollPosition);

                        view.invalidate();
                    }
                }
            }
        };

        ScheduledExecutorService sh = Executors.newScheduledThreadPool(1);

        final Runnable run = new Runnable() {
            @Override
            public void run() {
                DAY++;
                if (DAY == 21) {
                    DAY = 1;
                    MONTH++;
                }

                if (MONTH == 11) {
                    MONTH = 1;
                    YEAR++;
                }
                update.run();
            }
        };

        final Runnable run2 = new Runnable() {
            @Override
            public void run() {
                COUNT--;
                if (COUNT == 0) {
                    COUNT = 59;
                    runOnUiThread(run);
                }
                runOnUiThread(update);
            }
        };

        new Timer(true).scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(run2);


            }
        }, 5000, 5000);


        timer = new Runnable() {
            @Override
            public void run() {
                int speed = 75;
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {

                        MenuWatcher.pulse();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                update();
                            }
                        });
                    }
                }, speed, speed);
            }
        };
        //timer.run();
        runOnUiThread(update);


    }

    public void update() {
        update.run();
    }

    public static void updateEx(int scrollPosition) {
        if (scrollPosition != -1)
            ScrollPosition = scrollPosition;
        update.run();
    }

    public static void setNotifyAction() {
        if (notifyAction != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    notifyAction.run();
                    notifyAction = null;
                }
            }).run();


        }
    }

    public static void changeWindow(Window window) {

        if (view != null) {
            if (window != null) {
                view.changeWindow(W.get(window));
                ScrollPosition = view.getWindow().getScrollPosition();
            }
            view.setOverlaySetting(false);

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
                if (view != null) {
                    Window wnd = !view.getOverlaySetting() ? view.getWindow() : view.getOverlayWindow();

                    if (wnd != null && newScroller != 0) {
                        int max = wnd.getMaxScrollPosition() - MenuRects.contentInner.get().height();
                        max += MenuRects.line.get().height();
                        wnd.down = true;
                        if (newScroller < max) {

                            scrolled = true;
                            ScrollPosition = newScroller;
                            update.run();

                        } else {
                            wnd.down = false;
                            update.run();
                        }
                    }
                }
            }
        }

        if (event.getAction() == MotionEvent.ACTION_UP) {
            touch = false;

            if (!scrolled) {
                int yy = (int) event.getY() - (int) (MenuRects.menu.get().height() / 2);
                MenuRects.testHit((int) event.getX(), yy);

                if (view != null) {
                    if (view.getOverlaySetting() && view.getOverlayWindow() != null && MenuRects.contentInner.get().contains((int) event.getX(), (int) event.getY())) {
                        view.getOverlayWindow().checkHit((int) event.getX(), (int) event.getY() - (int) (MenuRects.icon.get().height() * 1.5));
                    } else if (!view.getOverlaySetting() && view.getWindow() != null && MenuRects.contentInner.get().contains((int) event.getX(), (int) event.getY())) {
                        view.getWindow().checkHit((int) event.getX(), (int) event.getY() - (int) (MenuRects.icon.get().height() * 1.5));
                    }
                }

            }
            scrolled = false;
        }

        return true;
    }


}
