package games.biitworx.starcitysim.window.content;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;

import java.util.ArrayList;
import java.util.List;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.BitmapDrawer;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Fonts;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.RectHelper;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.scifi.PlanetConst;
import games.biitworx.starcitysim.scifi.RandomRange;
import games.biitworx.starcitysim.scifi.planet.PlanetData;
import games.biitworx.starcitysim.scifi.planet.PlanetSurface;

/**
 * Created by marcel.weissgerber on 19.05.2016.
 */
public class PlanetContent extends Content {
    private PlanetData planet;
    private boolean clickable = false;


    public List<Scene> scenes = new ArrayList<>();

    public PlanetContent(PlanetData planet) {
        super(3f);
        this.planet = planet;
    }

    public PlanetContent(PlanetData planet, Runnable runnable) {
        super(3f);
        this.planet = planet;
        setAction(runnable);
        clickable = true;
    }

    public PlanetContent clickable(boolean clickable) {
        this.clickable = clickable;
        return this;
    }

    public PlanetContent height(float height) {
        this.lineHeight = height;
        return this;
    }

    @Override
    public void onDrawEx(Canvas canvas) {
        Game.ANIMATION = false;
        if (scenes.size() == 0) {
            scenes.add(new Scene());
        }
        if (!clickable && !Game.SCROLLS) {
            for (Scene s : scenes) {
                s.pos -= 30;
            }


        }
        if (clickable) {
            Rect innerContent = getInnerRect();
            Paint filler = new Paint();

            filler.setStyle(Paint.Style.FILL);

            Paint filler2 = new Paint();

            filler2.setStyle(Paint.Style.FILL);
            filler2.setColor(Colors.back001);
            filler.setShader(new LinearGradient((float) innerContent.left, (float) innerContent.top, (float) innerContent.right, (float) innerContent.top, Colors.back001, Color.argb(150, 0, 0, 0), Shader.TileMode.REPEAT));


            canvas.drawRect(innerContent, filler);


        }
        Rect circle = getInnerRect();
        ArrayList<Rect> rects = RectHelper.makeRectsEx(circle, 4);
        if (clickable) {

            circle = rects.get(0);

        }
        Rect circle2 = new Rect(0, 0, circle.width(), circle.height());
        Path p = new Path();
        float h = circle.height() / 2.5f;
        p.addCircle(circle.exactCenterX(), circle.exactCenterY(), h, Path.Direction.CCW);
        p.close();

        Paint circler = new Paint();
        circler.setStyle(Paint.Style.FILL);
        circler.setAntiAlias(true);


        if (!Game.SCROLLS)
            makeSurface(canvas, circle, circle2, circler, planet.getShaderSurface());
        else {
            circler.setColor(planet.getSurfaceColor());
            canvas.drawPath(p, circler);

        }

        Paint light = new Paint();
        light.setStyle(Paint.Style.FILL);
        light.setAntiAlias(true);

        int col001 = planet.getSurface() == PlanetSurface.SUN ? planet.getSurfaceColor2() : Color.argb(128, 0, 255, 255);

        light.setShader(new RadialGradient(circle.exactCenterX() + h, circle.exactCenterY() - h, h * 4f, col001, Color.argb(0, 255, 255, 255), Shader.TileMode.CLAMP));
        canvas.drawPath(p, light);
        light.setShader(new RadialGradient(circle.exactCenterX() + h / 2, circle.exactCenterY() - h / 2, h * 1.6f, Color.argb(1, 0, 0, 0), Color.argb(clickable ? 200 : 220, 0, 0, 0), Shader.TileMode.CLAMP));
        canvas.drawPath(p, light);
        light.setShader(new RadialGradient(circle.exactCenterX(), circle.exactCenterY(), h * 1.1f, Color.argb(1, 0, 0, 0), Color.argb(clickable ? 200 : 220, 0, 0, 0), Shader.TileMode.CLAMP));
        canvas.drawPath(p, light);

        int oldcol = Colors.backPainterLine2.getColor();
        Colors.backPainterLine2.setColor(Color.argb(230, 0, 0, 0));
        Colors.backPainterLine2.setStrokeWidth(clickable ? 1 : 1);

        canvas.drawPath(p, Colors.backPainterLine2);
        Colors.backPainterLine2.setColor(oldcol);
        Colors.backPainterLine2.setStrokeWidth(2);

        if (clickable) {

            Fonts.FONT.setTextSize((getContentRect().height() / 4.85f));

            rects = RectHelper.makeRect3(rects.get(1), (int) Fonts.FONT.getTextSize(), 2, 2);

            int hh = getContentRect().height() / 10;
            canvas.drawText(planet.getName(), (float) rects.get(1).left, rects.get(1).centerY() - hh, Fonts.FONT);
            Fonts.FONT.setTextSize((getContentRect().height() / 7));
            String surface = planet.getSurface() == PlanetSurface.ICE_ROCK ? T.get(R.string.content_planet_suface_ICE_ROCK) : planet.getSurface() == PlanetSurface.ICE ? T.get(R.string.content_planet_suface_ICE)
                    : planet.getSurface() == PlanetSurface.GAS ? T.get(R.string.content_planet_suface_GAS) : planet.getSurface() == PlanetSurface.SUN ? T.get(R.string.content_planet_suface_SUN) : planet.getSurface() == PlanetSurface.MOON ? T.get(R.string.content_planet_suface_MOON) : T.get(R.string.content_planet_suface_ROCK);
            canvas.drawText(T.get(R.string.content_planet_surface), (float) rects.get(1).left, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 0.8), Fonts.FONT);
            canvas.drawText(surface, (float) rects.get(1).left + hh * 16, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 0.8), Fonts.FONT);

            canvas.drawText(T.get(R.string.content_planet_radius), (float) rects.get(1).left, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 1.8), Fonts.FONT);
            canvas.drawText("" + planet.getRadius() * PlanetConst.METER / 2, (float) rects.get(1).left + hh * 16, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 1.8), Fonts.FONT);

            canvas.drawText(T.get(R.string.content_planet_temp), (float) rects.get(1).left, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 2.8), Fonts.FONT);
            canvas.drawText("" + planet.getTemprature(), (float) rects.get(1).left + hh * 16, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 2.8), Fonts.FONT);

            canvas.drawRect(getInnerRect(), Colors.backPainterLine2);
        }
        Game.ANIMATION = true;

    }

    private void makeSurface(Canvas canvas, Rect circle, Rect circle2, Paint circler, int surface) {
        int id = 0;
        if (planet.getSurface() == PlanetSurface.ROCK && surface < 15) {

            id = getRockId(surface);

        }
        if (planet.getSurface() == PlanetSurface.SUN && surface < 6) {
            id = getSunId(surface);
        }
        if (planet.getSurface() == PlanetSurface.ICE && surface < 15) {
            id = getIceId(surface);
        }
        if (planet.getSurface() == PlanetSurface.GAS && surface < 15) {
            id = getGasId(surface);
        }
        if (planet.getSurface() == PlanetSurface.ICE_ROCK && surface < 15) {
            id = getGrasId(surface);

        }
        if (planet.getSurface() == PlanetSurface.MOON && surface < 43) {

            if (surface < 15)
                id = getRockId(surface);
            else if (surface < 29)
                id = getIceId(surface - 15);
            else
                id = getGrasId(surface - 29);
        }
        if (id > 0) {
            Bitmap b = drawOnCircle(circle2, B.get(id), circler);

            BitmapDrawer.drawImage(b, canvas, circle, null, true);
        }
    }

    private int getRockId(int id) {
        if (id == 2)
            return R.drawable.rock002;
        if (id == 3)
            return R.drawable.rock003;
        if (id == 4)
            return R.drawable.rock004;
        if (id == 5)
            return R.drawable.rock005;
        if (id == 6)
            return R.drawable.rock006;
        if (id == 7)
            return R.drawable.rock007;
        if (id == 8)
            return R.drawable.rock008;
        if (id == 9)
            return R.drawable.rock009;
        if (id == 10)
            return R.drawable.rock010;
        if (id == 11)
            return R.drawable.rock011;
        if (id == 12)
            return R.drawable.rock012;
        if (id == 13)
            return R.drawable.rock013;
        if (id == 14)
            return R.drawable.rock014;

        return R.drawable.rock001;

    }

    private int getSunId(int id) {
        if (id == 2)
            return R.drawable.sun002;
        if (id == 3)
            return R.drawable.sun003;
        if (id == 4)
            return R.drawable.sun004;
        if (id == 5)
            return R.drawable.sun005;

        return R.drawable.sun001;

    }

    private int getIceId(int id) {
        if (id == 2)
            return R.drawable.ice002;
        if (id == 3)
            return R.drawable.ice003;
        if (id == 4)
            return R.drawable.ice004;
        if (id == 5)
            return R.drawable.ice005;
        if (id == 6)
            return R.drawable.ice006;
        if (id == 7)
            return R.drawable.ice007;
        if (id == 8)
            return R.drawable.ice008;
        if (id == 9)
            return R.drawable.ice009;
        if (id == 10)
            return R.drawable.ice010;
        if (id == 11)
            return R.drawable.ice011;
        if (id == 12)
            return R.drawable.ice012;
        if (id == 13)
            return R.drawable.ice013;
        if (id == 14)
            return R.drawable.ice014;

        return R.drawable.ice001;

    }

    private int getGasId(int id) {
        if (id == 2)
            return R.drawable.gas002;
        if (id == 3)
            return R.drawable.gas003;
        if (id == 4)
            return R.drawable.gas004;
        if (id == 5)
            return R.drawable.gas005;
        if (id == 6)
            return R.drawable.gas006;
        if (id == 7)
            return R.drawable.gas007;
        if (id == 8)
            return R.drawable.gas008;
        if (id == 9)
            return R.drawable.gas009;
        if (id == 10)
            return R.drawable.gas010;
        if (id == 11)
            return R.drawable.gas011;
        if (id == 12)
            return R.drawable.gas012;
        if (id == 13)
            return R.drawable.gas013;
        if (id == 14)
            return R.drawable.gas014;

        return R.drawable.gas001;

    }

    private int getWaterId(int id) {
        if (id == 2)
            return R.drawable.water002;
        if (id == 3)
            return R.drawable.water003;
        if (id == 4)
            return R.drawable.water004;
        if (id == 5)
            return R.drawable.water005;


        return R.drawable.water001;

    }

    private int getGrasId(int id) {
        if (id == 2)
            return R.drawable.gras002;
        if (id == 3)
            return R.drawable.gras003;
        if (id == 4)
            return R.drawable.gras004;
        if (id == 5)
            return R.drawable.gras005;
        if (id == 6)
            return R.drawable.gras006;
        if (id == 7)
            return R.drawable.gras007;
        if (id == 8)
            return R.drawable.gras008;
        if (id == 9)
            return R.drawable.gras009;
        if (id == 10)
            return R.drawable.gras010;
        if (id == 11)
            return R.drawable.gras011;
        if (id == 12)
            return R.drawable.gras012;
        if (id == 13)
            return R.drawable.gras013;
        if (id == 14)
            return R.drawable.gras014;

        return R.drawable.gras001;

    }

    private Bitmap multiplyBitmap(Bitmap bitmap, Rect map) {
        Bitmap bit = Bitmap.createBitmap(map.width(), map.height(), Bitmap.Config.ARGB_8888);

        Canvas c = new Canvas(bit);

        int xx = map.width() / bitmap.getWidth();
        int yy = map.height() / bitmap.getHeight();

        for (int x = 0; x <= xx; x++) {
            for (int y = 0; y <= yy; y++) {

                Bitmap bitmap1 = bitmap;

                c.drawBitmap(bitmap1, x * bitmap.getWidth(), y * bitmap.getHeight(), null);
            }
        }
        return bit;
    }

    private Bitmap drawOnCircle(Rect circle, Bitmap bitmap, Paint painter) {
/*
        if (!clickable) {
            bitmap = multiplyBitmap(bitmap, circle);
        }*/

        Bitmap result = Bitmap.createBitmap(circle.width(), circle.height(), Bitmap.Config.ARGB_8888);
        Path p = new Path();
        p.addCircle(circle.exactCenterX(), circle.exactCenterY(), circle.height() / 2.5f, Path.Direction.CCW);
        p.close();

        Canvas c = new Canvas(result);
        c.drawPath(p, painter);
        c.clipPath(p, Region.Op.INTERSECT);
        if (!clickable && !Game.SCROLLS) {

            if (scenes.size() == 1) {
                Scene s = new Scene();
                s.pos = scenes.get(0).pos + circle.width();

                scenes.add(s);
            }

            if (scenes.size() == 2) {
                if (scenes.get(0).pos < (0 - circle.width())) {
                    scenes.remove(0);
                    Scene s = new Scene();
                    s.pos = scenes.get(0).pos + circle.width();

                    scenes.add(s);
                }
            }


            for (Scene s : scenes) {
                circle = new Rect((int) s.pos, circle.top, (int) s.pos + circle.width(), circle.bottom);

                BitmapDrawer.drawImage(bitmap, c, circle, null, true);
            }


        } else {
            BitmapDrawer.drawImage(bitmap, c, circle, null, true);
        }
        return result;
    }

    class Scene {
        public float pos = 0;

    }
}
