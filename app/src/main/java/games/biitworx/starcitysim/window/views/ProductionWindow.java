package games.biitworx.starcitysim.window.views;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.TE;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.basic.MenuCounter;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.views.production.ShipyardWindow;

/**
 * Created by marcel.weissgerber on 27.04.2016.
 */
public class ProductionWindow extends Window {
    public ProductionWindow() {
        super(TE.get(R.string.window_production_title));


        getContents().add(new MenuItemContent(null, B.get(R.drawable.shipyardback), TE.get(R.string.window_production_shipyard_title), TE.get(R.string.window_production_shipyard_desc), MenuCounter.productionCounter.shipyard, Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));

        getContents().add(new MenuItemContent(null, B.get( R.drawable.menuback), TE.get(R.string.window_menu_title), TE.get(R.string.window_menu_desc), MenuCounter.menu.concat(" ").concat(TE.get(R.string.items_count)),Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}
