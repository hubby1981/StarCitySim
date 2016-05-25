package games.biitworx.starcitysim.window.views.systems;

import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.scifi.PlanetSystem;
import games.biitworx.starcitysim.scifi.planet.PlanetData;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.PlanetContent;

/**
 * Created by marcel.weissgerber on 18.05.2016.
 */
public class PlanetWindow extends Window {

    public PlanetWindow(PlanetSystem planetSystem) {
        super(planetSystem.getName());

        for (final PlanetData p : planetSystem.getPlanets()) {
            getContents().add(new PlanetContent(p, new Runnable() {
                @Override
                public void run() {
                    Game.changeWindow(new PlanetDetailWindow(p));
                }
            }));
        }


    }
}
