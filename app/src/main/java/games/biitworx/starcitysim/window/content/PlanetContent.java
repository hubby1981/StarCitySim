package games.biitworx.starcitysim.window.content;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;

import java.util.ArrayList;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.BitmapDrawer;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Fonts;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.RectHelper;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.scifi.PlanetConst;
import games.biitworx.starcitysim.scifi.planet.PlanetData;
import games.biitworx.starcitysim.scifi.planet.PlanetSurface;
import games.biitworx.starcitysim.scifi.planet.rock.RockPlanetTerrain;

/**
 * Created by marcel.weissgerber on 19.05.2016.
 */
public class PlanetContent extends Content {
    private PlanetData planet;
    private boolean clickable = false;

    public PlanetContent(PlanetData planet) {
        super(3);
        this.planet = planet;
    }

    public PlanetContent(PlanetData planet, Runnable runnable) {
        super(3);
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
        int oldcol = Colors.backPainterLine2.getColor();
        Colors.backPainterLine2.setColor(planet.surfaceColor);
        Colors.backPainterLine2.setStrokeWidth(5);
        canvas.drawPath(p, Colors.backPainterLine2);
        Colors.backPainterLine2.setColor(oldcol);
        Colors.backPainterLine2.setStrokeWidth(2);
        Paint circler = new Paint();
        circler.setStyle(Paint.Style.FILL);
        circler.setAntiAlias(true);
        circler.setColor(planet.getSurfaceColor());
        if (!clickable)
            circler.setShadowLayer(10 * planet.getAtmosphereThickness(), 0, 0, planet.getSurfaceColor2());
        canvas.drawPath(p, circler);


        makeSurface(canvas, circle, circle2, circler, planet.getShaderSurfaceA());
       if(planet.getSurface()!=PlanetSurface.SUN) {
           makeSurfaceEx(canvas, circle, circle2, circler, planet.getShaderSurfaceB());
           makeSurfaceEx(canvas, circle, circle2, circler, planet.getShaderSurfaceC());
           makeSurface2(canvas, circle, circle2, circler, planet.getShaderSurfaceD());
           makeSurface3(canvas, circle, circle2, circler, planet.getShaderSurfaceE());
       }

        Paint light = new Paint();
        light.setStyle(Paint.Style.FILL);
        light.setAntiAlias(true);
        light.setShader(new LinearGradient((float) (circle.centerX() - circle.width() / 8), circle.exactCenterY(), circle.right - circle.width() / (clickable ? 8 : 4), circle.exactCenterY(), Color.argb(clickable ? 150 : 200, 0, 0, 0), Color.argb(0, 0, 0, 0), Shader.TileMode.CLAMP));
        canvas.drawPath(p, light);

        if (clickable) {

            Fonts.FONT.setTextSize((getContentRect().height() / 4.85f));

            rects = RectHelper.makeRect3(rects.get(1), (int) Fonts.FONT.getTextSize(), 2, 2);

            int hh = getContentRect().height() / 10;
            canvas.drawText(planet.getName(), (float) rects.get(1).left, rects.get(1).centerY() - hh, Fonts.FONT);
            Fonts.FONT.setTextSize((getContentRect().height() / 7));
            String surface = planet.getSurface() == PlanetSurface.ICE_ROCK ? T.get(R.string.content_planet_suface_ICE_ROCK) : planet.getSurface() == PlanetSurface.ICE ? T.get(R.string.content_planet_suface_ICE)
                    : planet.getSurface() == PlanetSurface.GAS ? T.get(R.string.content_planet_suface_GAS) : planet.getSurface() == PlanetSurface.SUN ? T.get(R.string.content_planet_suface_SUN) : T.get(R.string.content_planet_suface_ROCK);
            canvas.drawText(T.get(R.string.content_planet_surface), (float) rects.get(1).left + hh, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 0.8), Fonts.FONT);
            canvas.drawText(surface, (float) rects.get(1).left + hh * 16, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 0.8), Fonts.FONT);

            canvas.drawText(T.get(R.string.content_planet_radius), (float) rects.get(1).left + hh, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 1.8), Fonts.FONT);
            canvas.drawText("" + planet.getRadius() * PlanetConst.METER / 2, (float) rects.get(1).left + hh * 16, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 1.8), Fonts.FONT);

            canvas.drawText(T.get(R.string.content_planet_temp), (float) rects.get(1).left + hh, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 2.8), Fonts.FONT);
            canvas.drawText("" + planet.getTemprature(), (float) rects.get(1).left + hh * 16, rects.get(1).centerY() + (float) (Fonts.FONT.getTextSize() * 2.8), Fonts.FONT);

            canvas.drawRect(getInnerRect(), Colors.backPainterLine2);
        }

    }

    private void makeSurface(Canvas canvas, Rect circle, Rect circle2, Paint circler, int surface) {
        int id = 0;
        if (planet.getSurface() == PlanetSurface.ROCK && surface < 6) {

            id = getRockId(surface);

        }
        if (planet.getSurface() == PlanetSurface.SUN && surface < 6) {
            id = getSunId(surface);
        }
        if (planet.getSurface() == PlanetSurface.ICE && surface < 6) {
            id = getIceId(surface);
        }
        if (planet.getSurface() == PlanetSurface.GAS && surface < 6) {
            id = getGasId(surface);
        }
        if (planet.getSurface() == PlanetSurface.ICE_ROCK && surface < 6) {
            id = getRockId(surface);
            Bitmap b = drawOnCircle(circle2, B.get(id), circler);

            BitmapDrawer.drawImage(b, canvas, circle, null, true);
            id = getIceId(surface);

        }

        if (id > 0) {
            Bitmap b = drawOnCircle(circle2, B.get(id), circler);

            BitmapDrawer.drawImage(b, canvas, circle, null, true);
        }
    }
    private void makeSurfaceEx(Canvas canvas, Rect circle, Rect circle2, Paint circler, int surface) {
        int id = 0;
        if (planet.getSurface() == PlanetSurface.ROCK && surface < 6) {

            id = getRockId(surface);

        }

        if (planet.getSurface() == PlanetSurface.ICE && surface < 6) {
            id = getIceId(surface);
        }
        if (planet.getSurface() == PlanetSurface.GAS && surface < 6) {
            id = getGasId(surface);
        }
        if (planet.getSurface() == PlanetSurface.ICE_ROCK && surface < 6) {
            id = getRockId(surface);
            Bitmap b = drawOnCircle(circle2, B.get(id), circler);

            BitmapDrawer.drawImage(b, canvas, circle, null, true);
            id = getIceId(surface);

        }

        if (id > 0) {
            Bitmap b = drawOnCircle(circle2, B.get(id), circler);

            BitmapDrawer.drawImage(b, canvas, circle, null, true);
        }
    }

    private void makeSurface2(Canvas canvas, Rect circle, Rect circle2, Paint circler, int surface) {
        int id = 0;
        if (planet.getSurface() == PlanetSurface.ROCK && surface < 6) {
            id = getWaterId(surface);
        }

        if (planet.getSurface() == PlanetSurface.ICE_ROCK && surface < 6) {
            id = getWaterId(surface);

        }

        if (id > 0) {
            Bitmap b = drawOnCircle(circle2, B.get(id), circler);

            BitmapDrawer.drawImage(b, canvas, circle, null, true);
        }
    }

    private void makeSurface3(Canvas canvas, Rect circle, Rect circle2, Paint circler, int surface) {
        int id = 0;
        if (planet.getSurface() == PlanetSurface.ROCK && surface < 6) {
            id = getGrasId(surface);
        }

        if (planet.getSurface() == PlanetSurface.ICE_ROCK && surface < 6) {
            id = getGrasId(surface);

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
        if (id == 1)
            return R.drawable.rock001;
        return 0;
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
        if (id == 1)
            return R.drawable.sun001;
        return 0;
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
        if (id == 1)
            return R.drawable.ice001;
        return 0;
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

        if (id == 1)
            return R.drawable.gas001;
        return 0;
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

        if (id == 1)
            return R.drawable.water001;
        return 0;
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

        if (id == 1)
            return R.drawable.gras001;
        return 0;
    }


    private Bitmap drawOnCircle(Rect circle, Bitmap bitmap, Paint painter) {

        Bitmap result = Bitmap.createBitmap(circle.width(), circle.height(), Bitmap.Config.ARGB_8888);
        Path p = new Path();
        p.addCircle(circle.exactCenterX(), circle.exactCenterY(), circle.height() / 2.5f, Path.Direction.CCW);
        p.close();

        Canvas c = new Canvas(result);
        c.drawPath(p, painter);
        c.clipPath(p, Region.Op.INTERSECT);
        BitmapDrawer.drawImage(bitmap, c, circle, null, true);

        return result;
    }
}
