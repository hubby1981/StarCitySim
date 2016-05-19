package games.biitworx.starcitysim.scifi.planet;

import android.graphics.Color;

import games.biitworx.starcitysim.scifi.PlanetConst;
import games.biitworx.starcitysim.scifi.RandomRange;
import games.biitworx.starcitysim.window.content.PlanetContent;

/**
 * Created by marcel.weissgerber on 18.05.2016.
 */
public class PlanetData extends PlanetCoreData {
    private String name;
    private PlanetSurface surface;
    private float surfaceThickness = PlanetConst.MIN_PST;
    private float atmosphereThickness = PlanetConst.MIN_PAT;
    private float radius = 0f;
    public int surfaceColor;
    private int shaderSurfaceA = RandomRange.getRandom(1, 6);
    private int shaderSurfaceB = RandomRange.getRandom(1, 6);
    private int shaderSurfaceC = RandomRange.getRandom(1, 6);
    private int shaderSurfaceD = RandomRange.getRandom(1, 6);
    private int shaderSurfaceE = RandomRange.getRandom(1, 6);
    private float temprature;
    private float day;

    public PlanetData(String name) {
        super();
        this.name = name;
        surfaceThickness = RandomRange.getFloat(PlanetConst.MIN_PST, PlanetConst.MAX_PST);
        atmosphereThickness = RandomRange.getFloat(PlanetConst.MIN_PAT, PlanetConst.MAX_PAT);
        radius = (super.mass + surfaceThickness + atmosphereThickness) * (RandomRange.getFloat(PlanetConst.MIN_PFM, PlanetConst.MAX_PFM));
        radius = Math.round(radius);
        if (radius > 35) radius = 35;

        int sf = RandomRange.getRandom(1, 100);
        if (sf < (PlanetConst.GAS_PLANETS)) {
            surface = PlanetSurface.GAS;
        } else if (sf > PlanetConst.GAS_PLANETS && sf < PlanetConst.ROCK_PLANETS) {
            surface = PlanetSurface.ROCK;

        }else if (sf > PlanetConst.ROCK_PLANETS && sf < PlanetConst.ICE_PLANETS) {
            surface = PlanetSurface.ICE;

        }else  {
            surface = PlanetSurface.ICE_ROCK;

        }

        temprature=sf;

        if (surface == PlanetSurface.ROCK) {
            surfaceColor = Color.argb(255, RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK), RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK), RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK));

            //temprature = RandomRange.getFloat(PlanetConst.MIN_PTR, PlanetConst.MAX_PTR);
        } else if (surface == PlanetSurface.ICE) {
            surfaceColor = Color.argb(255, RandomRange.getRandom(PlanetConst.MIN_COLOR_ICE / 4, PlanetConst.MAX_COLOR_ICE / 4), RandomRange.getRandom(PlanetConst.MIN_COLOR_ICE, PlanetConst.MAX_COLOR_ICE), RandomRange.getRandom(PlanetConst.MIN_COLOR_ICE, PlanetConst.MAX_COLOR_ICE));
            //temprature = RandomRange.getFloat(PlanetConst.MIN_PTI, PlanetConst.MAX_PTI);

        } else if (surface == PlanetSurface.GAS) {
            surfaceColor = Color.argb(255, RandomRange.getRandom(PlanetConst.MIN_COLOR_GAS, PlanetConst.MAX_COLOR_GAS), 50, 100);
            //temprature = RandomRange.getFloat(PlanetConst.MIN_PTG, PlanetConst.MAX_PTG);

        } else {
            surfaceColor = Color.argb(255, RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK / 2, PlanetConst.MAX_COLOR_ROCK / 2), RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK), RandomRange.getRandom(PlanetConst.MIN_COLOR_ICE, PlanetConst.MAX_COLOR_ICE));
            //temprature = RandomRange.getFloat(PlanetConst.MIN_PTIR, PlanetConst.MAX_PTIR);

        }
        day = RandomRange.getFloat(PlanetConst.MIN_PSR, PlanetConst.MAX_PSR);

    }


    public float getRadius() {
        return radius;
    }


    public int getSurfaceColor() {
        return surfaceColor;
    }

    public PlanetSurface getSurface() {
        return surface;
    }

    public String getName() {
        return name;
    }

    public int getShaderSurfaceA() {
        return shaderSurfaceA;
    }

    public int getShaderSurfaceB() {
        return shaderSurfaceB;
    }

    public int getShaderSurfaceC() {
        return shaderSurfaceC;
    }

    public int getShaderSurfaceD() {
        return shaderSurfaceD;
    }

    public int getShaderSurfaceE() {
        return shaderSurfaceE;
    }

    public float getAtmosphereThickness() {
        return atmosphereThickness;
    }

    public float getTemprature() {
        return temprature;
    }

    public float getDay() {
        return day;
    }
}
