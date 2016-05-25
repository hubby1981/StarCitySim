package games.biitworx.starcitysim.scifi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@DbTable(name = "system")
public class PlanetSystem extends BaseDataObject{
    @DbField(name = "name")
    private String name;
    @DbReference(name = "systemPlanets", tableA = "system", tableB = "planet")
    private List<PlanetData> planets = new ArrayList<>();

    public PlanetSystem(String name,List<PlanetData> planets) {

        this.name = name;
        this.planets = planets;
    }

    public PlanetSystem(String name) {

        this.name = name;
        String sunName = name.length() > 3 ? name.substring(0, RandomRange.getRandom(2, 4)) : name.substring(0, 2);
        PlanetData sun = new PlanetData(sunName, PlanetSurface.SUN, null);

        add(sun);
        int max = RandomRange.getRandom(RandomRange.getRandom(2, 4), RandomRange.getRandom(5, 12));

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
}
