package games.biitworx.starcitysim.window.views;

import android.graphics.Color;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.basic.MenuCounter;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.views.production.ShipyardWindow;

/**
 * Created by marcel.weissgerber on 27.04.2016.
 */
public class ProductionWindow extends Window {
    public ProductionWindow() {
        super(T.get(R.string.window_production_title));


        getContents().add(new MenuItemContent(null, B.get(R.drawable.shipyardback),T.get(R.string.window_production_shipyard_title), T.get(R.string.window_production_shipyard_desc), MenuCounter.productionCounter.shipyard, Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get( R.drawable.menuback), T.get(R.string.window_menu_title),T.get(R.string.window_menu_desc), MenuCounter.menu.concat(" ").concat(T.get(R.string.items_count)), Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}
