package games.biitworx.starcitysim.window.views.systems;

import java.util.ArrayList;
import java.util.List;

import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.scifi.RandomRange;
import games.biitworx.starcitysim.scifi.System;
import games.biitworx.starcitysim.scifi.planet.PlanetData;
import games.biitworx.starcitysim.scifi.planet.PlanetSurface;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.PlanetContent;

/**
 * Created by marcel.weissgerber on 18.05.2016.
 */
public class PlanetWindow extends Window {

    public PlanetWindow(System system) {
        super(system.getName());

        for (final PlanetData p : system.getPlanets()) {
            getContents().add(new PlanetContent(p, new Runnable() {
                @Override
                public void run() {
                    Game.changeWindow(new PlanetDetailWindow(p));
                }
            }));
        }


    }
}
