package games.biitworx.starcitysim.window.views.systems;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.TE;
import games.biitworx.starcitysim.scifi.PlanetConst;
import games.biitworx.starcitysim.scifi.planet.PlanetData;
import games.biitworx.starcitysim.scifi.planet.PlanetSurface;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.ButtonContent;
import games.biitworx.starcitysim.window.content.LineContent;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.content.PlanetContent;
import games.biitworx.starcitysim.window.content.SpacerContent;
import games.biitworx.starcitysim.window.content.TextContent;
import games.biitworx.starcitysim.window.content.VirtualLineContents;

/**
 * Created by marcel.weissgerber on 20.05.2016.
 */

public class PlanetDetailWindow extends Window {
    public PlanetDetailWindow(final PlanetData planet) {
        super(planet.getName());


        getContents().add(new PlanetContent(planet).clickable(false).height(10));
        getContents().add(LineContent.line());

        if(planet.getOrbits().size()>0) {
            int count =  planet.getOrbits().size();
            getContents().add(new MenuItemContent(null, B.get(R.drawable.systemsback), TE.get(R.string.window_operations_systems_planet_orbit_title), TE.get(R.string.window_operations_systems_planet_orbit_desc),String.valueOf(count), Colors.back001,
                    new Runnable() {
                        @Override
                        public void run() {
                            Game.changeWindow(new PlanetOrbitWindow(planet));
                        }
                    }));
            getContents().add(LineContent.line());
        }

        VirtualLineContents table = new VirtualLineContents();
        table.getContents().add(new TextContent(TE.get(R.string.content_planet_mass)));
        table.getContents().add(new TextContent("" + planet.getRadius()));
        getContents().add(table);
        table = new VirtualLineContents();
        table.getContents().add(new TextContent(TE.get(R.string.content_planet_radius)));
        table.getContents().add(new TextContent("" + (planet.getRadius() * PlanetConst.METER) / 2));
        getContents().add(table);
        table = new VirtualLineContents();
        table.getContents().add(new TextContent("TEMP"));
        table.getContents().add(new TextContent("" + planet.getTemprature()));
        getContents().add(table);
        table = new VirtualLineContents();
        table.getContents().add(new TextContent(TE.get(R.string.content_planet_surface)));
        int id = R.string.content_planet_suface_ROCK;

        if (planet.getSurface() == PlanetSurface.GAS) id = R.string.content_planet_suface_GAS;
        if (planet.getSurface() == PlanetSurface.ICE) id = R.string.content_planet_suface_ICE;
        if (planet.getSurface() == PlanetSurface.SUN) id = R.string.content_planet_suface_SUN;
        if (planet.getSurface() == PlanetSurface.MOON) id = R.string.content_planet_suface_MOON;
        if (planet.getSurface() == PlanetSurface.ICE_ROCK)
            id = R.string.content_planet_suface_ICE_ROCK;

        table.getContents().add(new TextContent(TE.get(id)));

        getContents().add(table);

        if(planet.getParent()!=null) {
            getContents().add(new ButtonContent(TE.get(R.string.overlay_menu_back), new Runnable() {
                @Override
                public void run() {
                    Game.changeWindow(new PlanetDetailWindow(planet.getParent()));
                }
            }));

            getContents().add(new SpacerContent(4));

        }else   if(planet.getPlanetSystem()!=null) {
            getContents().add(new ButtonContent(TE.get(R.string.overlay_menu_back), new Runnable() {
                @Override
                public void run() {
                    Game.changeWindow(new PlanetWindow(planet.getPlanetSystem()));
                }
            }));

            getContents().add(new SpacerContent(4));

        }


    }
}
