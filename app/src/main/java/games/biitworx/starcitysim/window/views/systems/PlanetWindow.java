package games.biitworx.starcitysim.window.views.systems;

import java.util.List;

import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.scifi.PlanetSystem;
import games.biitworx.starcitysim.scifi.planet.PlanetData;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.ButtonContent;
import games.biitworx.starcitysim.window.content.PlanetContent;
import games.biitworx.starcitysim.window.content.SpacerContent;

/**
 * Created by marcel.weissgerber on 18.05.2016.
 */
public class PlanetWindow extends Window {

    public PlanetWindow(PlanetSystem planetSystem) {
        super(planetSystem.getName());


        for (final PlanetData p :  planetSystem.getPlanets()) {
            getContents().add(new PlanetContent(p, new Runnable() {
                @Override
                public void run() {
                    Game.changeWindow(new PlanetDetailWindow(p));
                }
            }));
        }
        getContents().add(new ButtonContent(T.get(R.string.overlay_menu_back), new Runnable() {
            @Override
            public void run() {
                Game.changeWindow(new SystemsWindow());
            }
        }));

        getContents().add(new SpacerContent(1));

    }
}
