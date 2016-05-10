package games.biitworx.starcitysim.window.views.production;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.scifi.NameGenerator;
import games.biitworx.starcitysim.window.content.ButtonContent;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.content.TextContent;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.views.ProductionWindow;

/**
 * Created by marcel.weissgerber on 22.04.2016.
 */
public class ShipyardWindow extends Window {
    public ShipyardWindow() {
        super(T.get(R.string.window_production_shipyard_title));
        getContents().add(new MenuItemContent(null, B.get(R.drawable.shipyardback), T.get(R.string.window_production_title), T.get(R.string.window_production_desc), "", Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ProductionWindow());
                    }
                }));

        getContents().add(new TextContent(T.get(R.string.content_race_name_header),-1,1f,2f));
        final TextContent text = new TextContent(new NameGenerator().getRaceName(),-1,1f,1.5f).padding(20);
        getContents().add(text);
        getContents().add(new TextContent("",-1,0.2f,2f,true));

        getContents().add(new TextContent(T.get(R.string.content_system_name_header), -1, 1f, 2f));
        final TextContent text2 = new TextContent(new NameGenerator().getSystemName(),-1,1f,1.5f).padding(20);
        getContents().add(text2);
        getContents().add(new TextContent("",-1,0.2f,2f,true));

        getContents().add(new TextContent(T.get(R.string.content_sun_name_header),-1,1f,2f));
        final TextContent text3 = new TextContent(new NameGenerator().getSunName(),-1,1f,1.5f).padding(20);
        getContents().add(text3);
        getContents().add(new TextContent("",-1,0.2f,2f,true));

        getContents().add(new ButtonContent(T.get(R.string.content_race_name_button), new Runnable() {
            @Override
            public void run() {
                text.text(new NameGenerator().getRaceName());
                text2.text(new NameGenerator().getSystemName());

                text3.text(new NameGenerator().getSunName());

                Game.update.run();
            }
        }));

    }
}
