package games.biitworx.starcitysim.scifi.planet;

import android.graphics.Color;

import games.biitworx.starcitysim.scifi.PlanetConst;
import games.biitworx.starcitysim.scifi.RandomRange;
import games.biitworx.starcitysim.scifi.planet.rock.RockPlanetTerrain;

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
    public int surfaceColor2;

    private int shaderSurfaceA = RandomRange.getRandom(1, 5);
    private int shaderSurfaceB = RandomRange.getRandom(1, 8);
    private int shaderSurfaceC = RandomRange.getRandom(1, 5);
    private int shaderSurfaceD = RandomRange.getRandom(1, 6);
    private int shaderSurfaceE = RandomRange.getRandom(1, 7);
    private float temprature;
    private float day;

    public PlanetData(String name) {
        super();
        this.name = name;
        surfaceThickness = RandomRange.getFloat(PlanetConst.MIN_PST, PlanetConst.MAX_PST);
        atmosphereThickness = RandomRange.getFloat(PlanetConst.MIN_PAT, PlanetConst.MAX_PAT);


        int sf = RandomRange.getRandom(1, 100);
        if (sf < (PlanetConst.GAS_PLANETS)) {
            surface = PlanetSurface.GAS;
        } else if (sf > PlanetConst.GAS_PLANETS && sf < PlanetConst.ROCK_PLANETS) {
            surface = PlanetSurface.ROCK;

        } else if (sf > PlanetConst.ROCK_PLANETS && sf < PlanetConst.ICE_PLANETS) {
            surface = PlanetSurface.ICE;

        } else {
            surface = PlanetSurface.ICE_ROCK;

        }
        radius();

        colors();
        day = RandomRange.getFloat(PlanetConst.MIN_PSR, PlanetConst.MAX_PSR);

    }

    private void radius() {
        int a = 0;
        int b = 0;

        if (surface == PlanetSurface.ICE) {
            a = 2;
            b = 6;
        }
        if (surface == PlanetSurface.ICE_ROCK) {
            a = 4;
            b = 12;

        }
        if (surface == PlanetSurface.ROCK) {
            a = 8;
            b = 32;

        }
        if (surface == PlanetSurface.GAS) {
            a = 16;
            b = 64;

        }

        if (surface == PlanetSurface.SUN) {
            a = 512;
            b = 4098;
            atmosphereThickness *= 4.6f;
        }
        radius = (super.mass + surfaceThickness) * (RandomRange.getRandom(a, b));


        radius = Math.round(radius);
    }

    private void colors() {
        if (surface == PlanetSurface.ROCK) {
            RockPlanetTerrain.init(250);
            surfaceColor = RockPlanetTerrain.getColor();
            RockPlanetTerrain.init(100);

            surfaceColor2 = RockPlanetTerrain.getColor();

            temprature = RandomRange.getFloat(PlanetConst.MIN_PTR, PlanetConst.MAX_PTR);
        } else if (surface == PlanetSurface.ICE) {
            surfaceColor = Color.argb(255, 0, RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK), RandomRange.getRandom(PlanetConst.MIN_COLOR_ICE, PlanetConst.MAX_COLOR_ICE));
            surfaceColor2 = Color.argb(128, 0, RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK), RandomRange.getRandom(PlanetConst.MIN_COLOR_ICE, PlanetConst.MAX_COLOR_ICE));

            temprature = RandomRange.getFloat(PlanetConst.MIN_PTI, PlanetConst.MAX_PTI);

        } else if (surface == PlanetSurface.GAS) {
            surfaceColor = Color.argb(255, RandomRange.getRandom(PlanetConst.MIN_COLOR_GAS, PlanetConst.MAX_COLOR_GAS), 0, 50);
            surfaceColor2 = Color.argb(128, RandomRange.getRandom(PlanetConst.MIN_COLOR_GAS, PlanetConst.MAX_COLOR_GAS), 0, 50);

            temprature = RandomRange.getFloat(PlanetConst.MIN_PTG, PlanetConst.MAX_PTG);

        } else if (surface == PlanetSurface.SUN) {

            temprature = RandomRange.getFloat(2500f, 50000f);

            if (temprature < 10000) {
                surfaceColor = Color.argb(255, RandomRange.getRandom(200, 255), 0, 0);
                surfaceColor2 = Color.argb(128, RandomRange.getRandom(200, 255), 0, 0);
                shaderSurfaceA = 1;
            } else if (temprature < 20000) {
                surfaceColor = Color.argb(255, RandomRange.getRandom(200, 255), RandomRange.getRandom(200, 255), 0);
                surfaceColor2 = Color.argb(128, RandomRange.getRandom(200, 255), RandomRange.getRandom(200, 255), 0);
                shaderSurfaceA = 2;

            } else if (temprature < 30000) {
                surfaceColor = Color.argb(255, 0, RandomRange.getRandom(200, 255), 0);
                surfaceColor2 = Color.argb(128, 0, RandomRange.getRandom(200, 255), 0);
                shaderSurfaceA = 3;

            } else if (temprature < 40000) {
                surfaceColor = Color.argb(255, RandomRange.getRandom(200, 255), 0, RandomRange.getRandom(200, 255));
                surfaceColor2 = Color.argb(128, RandomRange.getRandom(200, 255), 0, RandomRange.getRandom(200, 255));
                shaderSurfaceA = 4;

            } else {
                surfaceColor = Color.argb(255, 0, 0, RandomRange.getRandom(200, 255));
                surfaceColor2 = Color.argb(128, 0, 0, RandomRange.getRandom(200, 255));
                shaderSurfaceA = 5;

            }

        } else {
            surfaceColor = Color.argb(255, RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK / 2, PlanetConst.MAX_COLOR_ROCK / 2), RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK), RandomRange.getRandom(PlanetConst.MIN_COLOR_ICE, PlanetConst.MAX_COLOR_ICE));
            surfaceColor2 = Color.argb(128, RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK / 2, PlanetConst.MAX_COLOR_ROCK / 2), RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK), RandomRange.getRandom(PlanetConst.MIN_COLOR_ICE, PlanetConst.MAX_COLOR_ICE));

            temprature = RandomRange.getFloat(PlanetConst.MIN_PTIR, PlanetConst.MAX_PTIR);

        }

        if (surface == PlanetSurface.ICE) {
            temprature -= temprature * 4;
        }
        if (surface == PlanetSurface.ICE_ROCK) {
            temprature -= temprature * 2;
        }

        temprature = Math.round(temprature);
    }


    public float getRadius() {
        return radius;
    }


    public int getSurfaceColor() {
        return surfaceColor;
    }

    public int getSurfaceColor2() {
        return surfaceColor2;
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


    public PlanetData surfaceA(int value) {
        shaderSurfaceA = value;
        return this;
    }

    public PlanetData surfaceB(int value) {
        shaderSurfaceB = value;
        return this;
    }

    public PlanetData surfaceC(int value) {
        shaderSurfaceC = value;
        return this;
    }

    public PlanetData surfaceD(int value) {
        shaderSurfaceD = value;
        return this;
    }

    public PlanetData surfaceE(int value) {
        shaderSurfaceE = value;
        return this;
    }

    public PlanetData surface(PlanetSurface surface) {
        this.surface = surface;
        colors();
        radius();
        return this;
    }
}
