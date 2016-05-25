package games.biitworx.starcitysim.window.views.systems;

import java.util.List;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.data.helper.DbHelper;
import games.biitworx.starcitysim.scifi.PlanetSystem;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.MenuItemContent;

/**
 * Created by marce_000 on 25.05.2016.
 */
public class SystemsWindow extends Window {
    public SystemsWindow() {
        super(T.get(R.string.window_operations_systems_title));

        //new PlanetWindow(new PlanetSystem(new NameGenerator().getSystemName()))

        List<PlanetSystem> systems = Game.DATA.getData(PlanetSystem.class,null);

        for(final PlanetSystem p:systems){
            getContents().add(new MenuItemContent(null, B.get(R.drawable.systemsback),p.getName(),"",String.valueOf(systems.size()), Colors.back001,
                    new Runnable() {
                        @Override
                        public void run() {
                            Game.changeWindow(new PlanetWindow(p));
                        }
                    }));
        }
    }
}
