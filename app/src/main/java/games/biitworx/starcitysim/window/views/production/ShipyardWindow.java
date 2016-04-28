package games.biitworx.starcitysim.window.views.production;

import android.graphics.Color;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.content.TextContent;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.views.ProductionWindow;

/**
 * Created by marcel.weissgerber on 22.04.2016.
 */
public class ShipyardWindow extends Window {
    public ShipyardWindow() {
        super("Shipyard");
        getContents().add(new MenuItemContent(null, B.get(R.drawable.shipyardback), T.get(R.string.window_production_title), T.get(R.string.window_production_desc), "", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ProductionWindow());
                    }
                }));

    }
}
