package games.biitworx.starcitysim.window.content;

import android.graphics.Canvas;
import android.graphics.Color;
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
        p.addCircle(rc.exactCenterX(), rc.exactCenterY(), (rc.height() /3), Path.Direction.CW);
        int col = planet.getSurfaceColor();
        Paint painter = new Paint();
        painter.setAntiAlias(true);
        painter.setStyle(Paint.Style.FILL);
        painter.setColor(col);

        canvas.drawPath(p, painter);



        if(planet.getSurface()== PlanetSurface.ROCK && planet.getShader()<6){
            painter.setShader(getShaderRock(planet.getShader()));
            canvas.drawPath(p, painter);

        }
        else  if(planet.getSurface()== PlanetSurface.ICE && planet.getShader()<6){
            painter.setShader(getShaderIce(planet.getShader()));
            canvas.drawPath(p, painter);

        }
        else  if(planet.getSurface()== PlanetSurface.ICE_ROCK && planet.getShader()<6){
            painter.setShader(getShaderRock(planet.getShader()));
            canvas.drawPath(p, painter);
            painter.setShader(getShaderIce(planet.getShader()));
            canvas.drawPath(p, painter);

        }

        painter.setShadowLayer(20, 0, 0, col);
        painter.setShader(null);
        painter.setColor(Color.argb(25, 0, 0, 0));
        canvas.drawPath(p, painter);
        Colors.backPainterLine2.setStrokeWidth(5);
        Colors.backPainterLine2.setStyle(Paint.Style.FILL_AND_STROKE);
        Colors.backPainterLine2.setShadowLayer(rc.width() / 4, 0, 0, col);
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
