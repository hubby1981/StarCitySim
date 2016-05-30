package games.biitworx.starcitysim.window.views.systems;

import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.TE;
import games.biitworx.starcitysim.scifi.planet.PlanetData;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.ButtonContent;
import games.biitworx.starcitysim.window.content.LineContent;
import games.biitworx.starcitysim.window.content.PlanetContent;

/**
 * Created by marcel.weissgerber on 24.05.2016.
 */
public class PlanetOrbitWindow extends Window {
    public PlanetOrbitWindow(final PlanetData planetData) {
        super(TE.get(R.string.window_operations_systems_planet_orbit_title)+": "+planetData.getName());

        for (final PlanetData p : planetData.getOrbits())
            getContents().add(new PlanetContent(p, new Runnable() {
                @Override
                public void run() {
                    Game.changeWindow(new PlanetDetailWindow(p));
                }
            }));
        getContents().add(LineContent.line());
        getContents().add(new ButtonContent(TE.get(R.string.overlay_menu_back), new Runnable() {
            @Override
            public void run() {
                Game.changeWindow(new PlanetDetailWindow(planetData));
            }
        }));
    }
}
