package games.biitworx.starcitysim.window.views.systems;

import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.scifi.PlanetConst;
import games.biitworx.starcitysim.scifi.planet.PlanetData;
import games.biitworx.starcitysim.scifi.planet.PlanetSurface;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.LineContent;
import games.biitworx.starcitysim.window.content.PlanetContent;
import games.biitworx.starcitysim.window.content.TextContent;
import games.biitworx.starcitysim.window.content.VirtualLineContents;

/**
 * Created by marcel.weissgerber on 18.05.2016.
 */
public class PlanetWindow extends Window {

    public PlanetWindow(String name) {
        super(name);

        PlanetData planet = new PlanetData(name);
        getContents().add(new PlanetContent(planet));
        getContents().add(LineContent.line());

        VirtualLineContents table = new VirtualLineContents();
        table.getContents().add(new TextContent(T.get(R.string.content_planet_mass)));
        table.getContents().add(new TextContent("" + planet.getRadius()));
        getContents().add(table);
        table = new VirtualLineContents();
        table.getContents().add(new TextContent(T.get(R.string.content_planet_radius)));
        table.getContents().add(new TextContent("" + (planet.getRadius() * PlanetConst.METER) / 2));
        getContents().add(table);
        table = new VirtualLineContents();
        table.getContents().add(new TextContent("TEMP"));
        table.getContents().add(new TextContent("" + planet.getTemprature()));
        getContents().add(table);
        table = new VirtualLineContents();
        table.getContents().add(new TextContent(T.get(R.string.content_planet_surface)));
        int id = R.string.content_planet_suface_ROCK;

        if (planet.getSurface() == PlanetSurface.GAS) id = R.string.content_planet_suface_GAS;
        if (planet.getSurface() == PlanetSurface.ICE) id = R.string.content_planet_suface_ICE;
        if (planet.getSurface() == PlanetSurface.ICE_ROCK)
            id = R.string.content_planet_suface_ICE_ROCK;

        table.getContents().add(new TextContent(T.get(id)));

        getContents().add(table);


    }
}
