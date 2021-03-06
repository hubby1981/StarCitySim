package games.biitworx.starcitysim.scifi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.data.BaseDataObject;
import games.biitworx.starcitysim.data.DbField;
import games.biitworx.starcitysim.data.DbReference;
import games.biitworx.starcitysim.data.DbTable;
import games.biitworx.starcitysim.scifi.planet.PlanetCoreData;
import games.biitworx.starcitysim.scifi.planet.PlanetData;
import games.biitworx.starcitysim.scifi.planet.PlanetSurface;
import games.biitworx.starcitysim.window.content.PlanetContent;
import games.biitworx.starcitysim.window.views.systems.PlanetDetailWindow;

/**
 * Created by marcel.weissgerber on 24.05.2016.
 */
@DbTable
public class PlanetSystem extends BaseDataObject {
    @DbField
    private String name;
    @DbReference(items = PlanetData.class)
    private List<PlanetData> planets = new ArrayList<>();
    @DbField
    private String location="0.0.0.0.0";


    public PlanetSystem(String name) {

        this.name = name;
        this.location = ""+ RandomRange.getRandom(2,8)+"."+ RandomRange.getRandom(1,99)+ RandomRange.getRandom(100,900)+"."+ RandomRange.getRandom(10,90)+"."+ RandomRange.getRandom(1,9);

        String sunName = name.length() > 3 ? name.substring(0, RandomRange.getRandom(2, 4)) : name.substring(0, 2);
        PlanetData sun = new PlanetData(sunName, PlanetSurface.SUN, null);

        add(sun);
        int max = RandomRange.getRandom(RandomRange.getRandom(2, 4), RandomRange.getRandom(6, 25));

        List<Integer> oldsRock = new ArrayList<>();
        List<Integer> oldsIce = new ArrayList<>();
        List<Integer> oldsIceRock = new ArrayList<>();
        List<Integer> oldsGas = new ArrayList<>();

        for (int x = 1; x <= max; x++) {
            final PlanetData p = new PlanetData(name + " " + x);

            List<Integer> olds = p.getSurface() == PlanetSurface.ROCK ? oldsRock : p.getSurface() == PlanetSurface.ICE ? oldsIce : p.getSurface() == PlanetSurface.ICE_ROCK ? oldsIceRock : oldsGas;


            while (olds.contains(p.getShaderSurface())) {

                p.surfaceA(RandomRange.getRandom(1, 14));
            }
            olds.add(p.getShaderSurface());

            if (x <= max / 2 && (p.getSurface() == PlanetSurface.ICE || p.getSurface() == PlanetSurface.ICE_ROCK)) {
                p.surface(RandomRange.getRandom(1, 3) != 1 ? PlanetSurface.ROCK : PlanetSurface.GAS);

            }

            if (x > max / 2 && (p.getSurface() == PlanetSurface.ROCK || p.getSurface() == PlanetSurface.GAS)) {
                p.surface(RandomRange.getRandom(1, 2) == 1 ? PlanetSurface.ICE : PlanetSurface.ICE_ROCK);
            }

            add(p);


        }
    }

    public void add(PlanetData planet) {
        planets.add(planet.system(this));
    }

    public List<PlanetData> getPlanets() {
        return planets;
    }

    public String getName() {
        return name;
    }

    public PlanetSystem setName(String name){
        this.name = name;
        return this;
    }

    @Override
    protected void imported() {
        for (PlanetData p : getPlanets())
            p.system(this);
    }

    public PlanetSystem() {

    }

    public String getLocation() {
        return location;
    }
}
