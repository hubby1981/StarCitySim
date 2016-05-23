package games.biitworx.starcitysim.window.views.systems;

import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.scifi.RandomRange;
import games.biitworx.starcitysim.scifi.planet.PlanetData;
import games.biitworx.starcitysim.scifi.planet.PlanetSurface;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.PlanetContent;

/**
 * Created by marcel.weissgerber on 18.05.2016.
 */
public class PlanetWindow extends Window {

    public PlanetWindow(String name) {
        super(name);


        int max = RandomRange.getRandom(2, RandomRange.getRandom(8, 20));
        String sunName = name.length() > 3 ? name.substring(0, RandomRange.getRandom(2, 4)) : name.substring(0, 2);
        final PlanetData sun = new PlanetData(sunName).surface(PlanetSurface.SUN);
        getContents().add(new PlanetContent(sun, new Runnable() {
            @Override
            public void run() {
                Game.changeWindow(new PlanetDetailWindow(sun));
            }
        }));

        int old = sun.getShaderSurfaceA();
        for (int x = 1; x <= max; x++) {
            final PlanetData p = new PlanetData(name+" "+x);
            if (p.getShaderSurfaceA() == old ) {
                p.surfaceA(old + 1);
                old = p.getShaderSurfaceA();
            }

            if (p.getShaderSurfaceB() == old ) {
                p.surfaceB(old + 1);
                old = p.getShaderSurfaceB();

            }

            if (p.getShaderSurfaceC() == old ) {
                p.surfaceC(old + 1);
                old = p.getShaderSurfaceA();

            }
            if (x <= max / 2 && (p.getSurface() == PlanetSurface.ICE || p.getSurface() == PlanetSurface.ICE_ROCK)) {
                p.surface(RandomRange.getRandom(1, 3) != 1 ? PlanetSurface.ROCK : PlanetSurface.GAS);

            }

            if (x > max / 2 && (p.getSurface() == PlanetSurface.ROCK || p.getSurface() == PlanetSurface.GAS)) {
                p.surface(RandomRange.getRandom(1, 2) == 1 ? PlanetSurface.ICE : PlanetSurface.ICE_ROCK);
            }

            getContents().add(new PlanetContent(p, new Runnable() {
                @Override
                public void run() {
                    Game.changeWindow(new PlanetDetailWindow(p));
                }
            }));
        }



    }
}
