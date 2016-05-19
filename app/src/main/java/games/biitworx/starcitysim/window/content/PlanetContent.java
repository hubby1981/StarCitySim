package games.biitworx.starcitysim.window.content;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;

import java.util.ArrayList;

import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.RectHelper;
import games.biitworx.starcitysim.scifi.RandomRange;
import games.biitworx.starcitysim.scifi.planet.PlanetData;
import games.biitworx.starcitysim.scifi.planet.PlanetSurface;

/**
 * Created by marcel.weissgerber on 18.05.2016.
 */
public class PlanetContent extends Content {

    float[] values = new float[10];
    private PlanetData planet;

    public PlanetContent(PlanetData planet) {
        super(5);
        this.planet = planet;
    }

    @Override
    public void onDrawEx(Canvas canvas) {
        Rect innerContent = getInnerRect();

        ArrayList<Rect> rects = RectHelper.makeRectsEx(getInnerFullRect(), 5);

        Path p = new Path();
        Rect rc = rects.get(2);
        p.addCircle(rc.exactCenterX(), rc.exactCenterY(), (rc.height() / 3), Path.Direction.CW);
        int col = planet.getSurfaceColor();
        Paint painter = new Paint();
        painter.setAntiAlias(true);
        painter.setStyle(Paint.Style.FILL);
        painter.setColor(col);

        canvas.drawPath(p, painter);


        if (planet.getSurface() == PlanetSurface.ROCK && planet.getShaderSurfaceA() < 6) {
            painter.setShader(getShaderRock(planet.getShaderSurfaceA()));
            canvas.drawPath(p, painter);

        } else if (planet.getSurface() == PlanetSurface.ICE && planet.getShaderSurfaceA() < 6) {
            painter.setShader(getShaderIce(planet.getShaderSurfaceA()));
            canvas.drawPath(p, painter);

        }
        else if (planet.getSurface() == PlanetSurface.GAS && planet.getShaderSurfaceA() < 6) {
            painter.setShader(getShaderGas(planet.getShaderSurfaceA()));
            canvas.drawPath(p, painter);

        }else if (planet.getSurface() == PlanetSurface.ICE_ROCK && planet.getShaderSurfaceA() < 6) {
            painter.setShader(getShaderRock(planet.getShaderSurfaceA()));
            canvas.drawPath(p, painter);
            painter.setShader(getShaderIce(planet.getShaderSurfaceA()));
            canvas.drawPath(p, painter);

        }

        if (planet.getSurface() == PlanetSurface.ROCK && planet.getShaderSurfaceB() < 6) {
            painter.setShader(getShaderRock(planet.getShaderSurfaceB()));
            canvas.drawPath(p, painter);

        } else if (planet.getSurface() == PlanetSurface.ICE && planet.getShaderSurfaceB() < 6) {
            painter.setShader(getShaderIce(planet.getShaderSurfaceB()));
            canvas.drawPath(p, painter);

        } else if (planet.getSurface() == PlanetSurface.GAS && planet.getShaderSurfaceB() < 6) {
            painter.setShader(getShaderGas(planet.getShaderSurfaceB()));
            canvas.drawPath(p, painter);

        }    else if (planet.getSurface() == PlanetSurface.ICE_ROCK && planet.getShaderSurfaceB() < 6) {
            painter.setShader(getShaderRock(planet.getShaderSurfaceB()));
            canvas.drawPath(p, painter);
            painter.setShader(getShaderIce(planet.getShaderSurfaceB()));
            canvas.drawPath(p, painter);

        }

        if (planet.getSurface() == PlanetSurface.ROCK && planet.getShaderSurfaceC() < 6) {
            painter.setShader(getShaderRock(planet.getShaderSurfaceC()));
            canvas.drawPath(p, painter);

        } else if (planet.getSurface() == PlanetSurface.ICE && planet.getShaderSurfaceC() < 6) {
            painter.setShader(getShaderIce(planet.getShaderSurfaceC()));
            canvas.drawPath(p, painter);

        } else if (planet.getSurface() == PlanetSurface.GAS && planet.getShaderSurfaceC() < 6) {
            painter.setShader(getShaderGas(planet.getShaderSurfaceC()));
            canvas.drawPath(p, painter);

        }    else if (planet.getSurface() == PlanetSurface.ICE_ROCK && planet.getShaderSurfaceC() < 6) {
            painter.setShader(getShaderRock(planet.getShaderSurfaceC()));
            canvas.drawPath(p, painter);
            painter.setShader(getShaderIce(planet.getShaderSurfaceC()));
            canvas.drawPath(p, painter);

        }

        if (planet.getSurface() == PlanetSurface.ROCK && planet.getShaderSurfaceD() < 6) {
            painter.setShader(getShaderWater(planet.getShaderSurfaceD()));
            canvas.drawPath(p, painter);

        }else if (planet.getSurface() == PlanetSurface.ICE_ROCK && planet.getShaderSurfaceD() < 6) {
            painter.setShader(getShaderWater(planet.getShaderSurfaceD()));
            canvas.drawPath(p, painter);

        }

        if (planet.getSurface() == PlanetSurface.ROCK && planet.getShaderSurfaceE() < 6) {
            painter.setShader(getShaderGras(planet.getShaderSurfaceE()));
            canvas.drawPath(p, painter);

        }
        LinearGradient grad = new LinearGradient((rc.left), rc.bottom, rc.right, rc.top, Color.argb(255, 0, 0, 0), Color.argb(50, 0, 0, 0), Shader.TileMode.CLAMP);
        painter.setShader(grad);

        canvas.drawPath(p, painter);
        canvas.drawPath(p, painter);


        painter.setShader(null);


        Colors.backPainterLine2.setStrokeWidth(0);
        Colors.backPainterLine2.setStyle(Paint.Style.FILL_AND_STROKE);
        Colors.backPainterLine2.setShadowLayer(10*planet.getAtmosphereThickness(), 5, 5, col);
        canvas.drawPath(p, Colors.backPainterLine2);
        Colors.backPainterLine2.setStrokeWidth(2);
        Colors.backPainterLine2.setShadowLayer(0, 0, 0, Colors.backPainterLine2.getColor());
        Colors.backPainterLine2.setStyle(Paint.Style.STROKE);

    }


    public Shader getShaderRock(int id) {


        if (id == 1)
            return Colors.rock001;
        if (id == 2)
            return Colors.rock002;
        if (id == 3)
            return Colors.rock003;
        if (id == 4)
            return Colors.rock004;
        if (id == 5)
            return Colors.rock005;
        return Colors.rock001;
    }
    public Shader getShaderGas(int id) {


        if (id == 1)
            return Colors.gas001;
        if (id == 2)
            return Colors.gas002;
        if (id == 3)
            return Colors.gas003;
        if (id == 4)
            return Colors.gas004;
        if (id == 5)
            return Colors.gas005;
        return Colors.gas001;
    }


    public Shader getShaderWater(int id) {


        if (id == 1)
            return Colors.water001;
        if (id == 2)
            return Colors.water002;
        if (id == 3)
            return Colors.water003;
        if (id == 4)
            return Colors.water004;
        if (id == 5)
            return Colors.water005;
        return Colors.water001;
    }

    public Shader getShaderGras(int id) {


        if (id == 1)
            return Colors.gras001;
        if (id == 2)
            return Colors.gras002;
        if (id == 3)
            return Colors.gras003;
        if (id == 4)
            return Colors.gras004;
        if (id == 5)
            return Colors.gras005;
        return Colors.gras001;
    }

    public Shader getShaderIce(int id) {


        if (id == 1)
            return Colors.ice001;
        if (id == 2)
            return Colors.ice002;
        if (id == 3)
            return Colors.ice003;
        if (id == 4)
            return Colors.ice004;
        if (id == 5)
            return Colors.ice005;
        return Colors.ice001;
    }


    private Matrix getMatrix() {

        Matrix m = new Matrix();

        for (int x = 0; x < 10; x++) {
            values[x] = RandomRange.getFloat(0.1f, 1f);
        }
        return m;
    }
}
