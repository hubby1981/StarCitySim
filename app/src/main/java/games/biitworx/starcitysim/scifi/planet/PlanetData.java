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
    private int shader =  RandomRange.getRandom(1,6);

    public PlanetData(String name) {
        super();
        this.name = name;
        surfaceThickness = RandomRange.getFloat(PlanetConst.MIN_PST, PlanetConst.MAX_PST);
        atmosphereThickness = RandomRange.getFloat(PlanetConst.MIN_PAT, PlanetConst.MAX_PAT);
        radius = (super.mass + surfaceThickness + atmosphereThickness) * (RandomRange.getFloat(PlanetConst.MIN_PFM, PlanetConst.MAX_PFM));
        radius = Math.round(radius);
        if (radius > 35) radius = 35;

        int sf = RandomRange.getRandom(1, 100);
        if (sf > (PlanetConst.ROCK_PLANETS + PlanetConst.ICE_PLANETS)) {
            surface = PlanetSurface.ICE_ROCK;
        } else {
            if (sf > PlanetConst.ROCK_PLANETS) {
                surface = PlanetSurface.ICE;
            } else {
                surface = PlanetSurface.ROCK;
            }
        }

        if (surface == PlanetSurface.ROCK) {
            surfaceColor = Color.argb(255, RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK), RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK), RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK));
        } else if (surface == PlanetSurface.ICE) {
            surfaceColor = Color.argb(255, RandomRange.getRandom(PlanetConst.MIN_COLOR_ICE / 4, PlanetConst.MAX_COLOR_ICE / 4), RandomRange.getRandom(PlanetConst.MIN_COLOR_ICE, PlanetConst.MAX_COLOR_ICE), RandomRange.getRandom(PlanetConst.MIN_COLOR_ICE, PlanetConst.MAX_COLOR_ICE));
        } else {
            surfaceColor = Color.argb(255, RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK / 2, PlanetConst.MAX_COLOR_ROCK / 2), RandomRange.getRandom(PlanetConst.MIN_COLOR_ROCK, PlanetConst.MAX_COLOR_ROCK), RandomRange.getRandom(PlanetConst.MIN_COLOR_ICE, PlanetConst.MAX_COLOR_ICE));
        }


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

    public int getShader(){
        return shader;
    }

}
