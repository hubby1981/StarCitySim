package games.biitworx.starcitysim.scifi.planet;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import games.biitworx.starcitysim.data.DbField;
import games.biitworx.starcitysim.data.DbReference;
import games.biitworx.starcitysim.data.DbTable;
import games.biitworx.starcitysim.scifi.NameGenerator;
import games.biitworx.starcitysim.scifi.PlanetConst;
import games.biitworx.starcitysim.scifi.RandomRange;
import games.biitworx.starcitysim.scifi.PlanetSystem;

/**
 * Created by marcel.weissgerber on 18.05.2016.
 */
@DbTable(name = "planet")
public class PlanetData extends PlanetCoreData {
    @DbField(name = "name")
    private String name;
    @DbField(name = "surface")
    private PlanetSurface surface;
    @DbField(name = "surfaceThickness")
    private float surfaceThickness = PlanetConst.MIN_PST;
    @DbField(name = "atmosphereThickness")
    private float atmosphereThickness = PlanetConst.MIN_PAT;
    @DbField(name = "radius")
    private float radius = 0f;
    @DbField(name = "surfaceColor1")
    public int surfaceColor;
    @DbField(name = "surfaceColor2")
    public int surfaceColor2;
    @DbField(name = "shaderSurface")
    private int shaderSurface = RandomRange.getRandom(1, 5);
    @DbField(name = "temprature")
    private float temprature;
    @DbField(name = "day")
    private float day;
    @DbReference( tableA = "planet", tableB = "planet",items = PlanetData.class)
    private List<PlanetData> orbits = new ArrayList<>();

    private PlanetData parent;
    private PlanetSystem planetSystem;

    public PlanetData(){

    }

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

    public PlanetData system(PlanetSystem planetSystem) {
        this.planetSystem = planetSystem;
        return this;
    }

    public PlanetSystem getPlanetSystem() {
        return planetSystem;
    }

    public PlanetData(String name, PlanetSurface surface, PlanetData parent) {
        super();
        this.parent = parent;
        this.name = name;
        surfaceThickness = RandomRange.getFloat(PlanetConst.MIN_PST, PlanetConst.MAX_PST);
        atmosphereThickness = RandomRange.getFloat(PlanetConst.MIN_PAT, PlanetConst.MAX_PAT);


        this.surface = surface;
        radius();

        colors();
        day = RandomRange.getFloat(PlanetConst.MIN_PSR, PlanetConst.MAX_PSR);

    }

    public void addMoon(PlanetData p) {

        p.surface(PlanetSurface.MOON);
    }

    public PlanetData getParent() {
        return parent;
    }

    private void createOrbits() {
        if (RandomRange.getRandom(1, 2) == 2 && surface != PlanetSurface.MOON &&
        surface != PlanetSurface.SUN){
            int max = RandomRange.getRandom(1, 6);

            for (int x = 1; x <= max; x++) {
                orbits.add(new PlanetData(new NameGenerator().getPlanetName(), PlanetSurface.MOON, this));
            }
        }
    }

    private void radius() {
        int a = 0;
        int b = 0;

        if (surface == PlanetSurface.MOON) {
            a = 1;
            b = 2;
            surfaceA(RandomRange.getRandom(1, 42));

        }

        if (surface == PlanetSurface.ICE) {
            a = 2;
            b = 6;
            surfaceA(RandomRange.getRandom(1, 14));

        }
        if (surface == PlanetSurface.ICE_ROCK) {
            a = 4;
            b = 12;
            surfaceA(RandomRange.getRandom(1, 14));


        }
        if (surface == PlanetSurface.ROCK) {
            a = 8;
            b = 32;
            surfaceA(RandomRange.getRandom(1, 14));
        }
        if (surface == PlanetSurface.GAS) {
            a = 16;
            b = 64;
            surfaceA(RandomRange.getRandom(1, 14));

        }

        if (surface == PlanetSurface.SUN) {
            a = 512;
            b = 4098;
            atmosphereThickness *= 4.6f;
        } else {
            if (surface != PlanetSurface.MOON)
                createOrbits();

        }
        radius = (super.mass + surfaceThickness) * (RandomRange.getRandom(a, b));


        radius = Math.round(radius);
    }


    public List<PlanetData> getOrbits() {
        return orbits;
    }

    private void colors() {
        if (surface == PlanetSurface.ROCK) {
            surfaceColor = Color.argb(255, 0, RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK), RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK));
            surfaceColor2 = Color.argb(128, 0, RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK), RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK));


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
                shaderSurface = 1;
            } else if (temprature < 20000) {
                surfaceColor = Color.argb(255, RandomRange.getRandom(200, 255), RandomRange.getRandom(200, 255), 0);
                surfaceColor2 = Color.argb(128, RandomRange.getRandom(200, 255), RandomRange.getRandom(200, 255), 0);
                shaderSurface = 2;

            } else if (temprature < 30000) {
                surfaceColor = Color.argb(255, 0, RandomRange.getRandom(200, 255), 0);
                surfaceColor2 = Color.argb(128, 0, RandomRange.getRandom(200, 255), 0);
                shaderSurface = 3;

            } else if (temprature < 40000) {
                surfaceColor = Color.argb(255, RandomRange.getRandom(200, 255), 0, RandomRange.getRandom(200, 255));
                surfaceColor2 = Color.argb(128, RandomRange.getRandom(200, 255), 0, RandomRange.getRandom(200, 255));
                shaderSurface = 4;

            } else {
                surfaceColor = Color.argb(255, 0, 0, RandomRange.getRandom(200, 255));
                surfaceColor2 = Color.argb(128, 0, 0, RandomRange.getRandom(200, 255));
                shaderSurface = 5;

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

    public int getShaderSurface() {
        return shaderSurface;
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
        shaderSurface = value;
        return this;
    }


    public PlanetData surface(PlanetSurface surface) {
        this.surface = surface;
        colors();
        radius();
        return this;
    }

    @Override
    protected void imported() {

    }
}
