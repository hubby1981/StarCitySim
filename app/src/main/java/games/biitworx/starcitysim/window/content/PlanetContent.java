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
import games.biitworx.starcitysim.RD;
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
    private int cloud = RandomRange.getRandom(1, 1);

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
            makeSurface(canvas, circle, circle2, circler, planet);
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

    private void makeSurface(Canvas canvas, Rect circle, Rect circle2, Paint circler, PlanetData p) {
        int id = RD.getResIdByName(RD.getName(p.getSurface(), p.getShaderSurface()));

        if (id > 0) {
            Bitmap b = drawOnCircle(circle2, B.get(id), circler, true);

            BitmapDrawer.drawImage(b, canvas, circle, null, true);
        }


        id = RD.getResIdByName(RD.getCloudName(RandomRange.getRandom(1, RD.getMaxCloud())));
        if (id > 0 && cloud == 1&&planet.getSurface()!=PlanetSurface.SUN) {
            Bitmap b = drawOnCircle(circle2, B.get(id), circler, false);

            BitmapDrawer.drawImage(b, canvas, circle, null, true);
        }
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

    private Bitmap drawOnCircle(Rect circle, Bitmap bitmap, Paint painter, boolean fill) {
/*
        if (!clickable) {
            bitmap = multiplyBitmap(bitmap, circle);
        }*/

        Bitmap result = Bitmap.createBitmap(circle.width(), circle.height(), Bitmap.Config.ARGB_8888);
        Path p = new Path();
        p.addCircle(circle.exactCenterX(), circle.exactCenterY(), circle.height() / 2.5f, Path.Direction.CCW);
        p.close();

        Canvas c = new Canvas(result);
        if (!fill) {
            painter = new Paint();
            painter.setStyle(Paint.Style.FILL);
            painter.setColor(Color.argb(0, 0, 0, 0));
        }
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
                float pp = !fill?s.pos-30:s.pos;
                circle = new Rect((int) pp, circle.top, (int) pp + circle.width(), circle.bottom);

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
