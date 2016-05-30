package games.biitworx.starcitysim.window.views.production;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.TE;
import games.biitworx.starcitysim.scifi.NameGenerator;
import games.biitworx.starcitysim.scifi.PlanetSystem;
import games.biitworx.starcitysim.scifi.planet.PlanetData;
import games.biitworx.starcitysim.scifi.planet.PlanetSurface;
import games.biitworx.starcitysim.window.content.ButtonContent;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.content.PlanetContent;
import games.biitworx.starcitysim.window.content.SpacerContent;
import games.biitworx.starcitysim.window.content.TextContent;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.VirtualLineContents;
import games.biitworx.starcitysim.window.views.MenuWindow;
import games.biitworx.starcitysim.window.views.ProductionWindow;
import games.biitworx.starcitysim.window.views.enrionment.BankingWindow;
import games.biitworx.starcitysim.window.views.enrionment.banking.BankingMainSlotWindow;

/**
 * Created by marcel.weissgerber on 22.04.2016.
 */
public class ShipyardWindow extends Window {
    public ShipyardWindow() {
        super(TE.get(R.string.window_production_shipyard_title));

        getContents().add(new PlanetContent(new PlanetData(new NameGenerator().getSunName()).surface(PlanetSurface.ROCK)));

        getContents().add(new MenuItemContent(null, B.get(R.drawable.shipyardback), TE.get(R.string.window_production_title), TE.get(R.string.window_production_desc), "", Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ProductionWindow());
                    }
                }));

        getContents().add(new TextContent(TE.get(R.string.content_race_name_header), -1, 1f, 2f));
        final TextContent text = new TextContent(new NameGenerator().getRaceName(), -1, 1f, 1.5f).padding(20);
        getContents().add(text);
        getContents().add(new TextContent("", -1, 0.2f, 2f, true));

        getContents().add(new TextContent(TE.get(R.string.content_system_name_header), -1, 1f, 2f));
        final TextContent text2 = new TextContent(new NameGenerator().getSystemName(), -1, 1f, 1.5f).padding(20);
        getContents().add(text2);
        getContents().add(new TextContent("", -1, 0.2f, 2f, true));

        getContents().add(new TextContent(TE.get(R.string.content_sun_name_header), -1, 1f, 2f));
        final TextContent text3 = new TextContent(new NameGenerator().getSunName(), -1, 1f, 1.5f).padding(20);
        getContents().add(text3);
        getContents().add(new TextContent("", -1, 0.2f, 2f, true));


        getContents().add(new ButtonContent(TE.get(R.string.content_race_name_button), new Runnable() {
            @Override
            public void run() {
                text.text(new NameGenerator().getRaceName());
                text2.text(new NameGenerator().getSystemName());

                text3.text(new NameGenerator().getSunName());
                Game.ScrollPosition = 0;
                Game.DATA.insert(new PlanetSystem(new NameGenerator().getSystemName()),false,null);
                Game.update.run();
            }
        }));
        VirtualLineContents lineContents = new VirtualLineContents();
        lineContents.getContents().add(new ButtonContent("Yes", new Runnable() {
            @Override
            public void run() {
                Game.changeWindow(new MenuWindow());
            }
        }).seed(10));
        lineContents.getContents().add(new ButtonContent("No", new Runnable() {
            @Override
            public void run() {
                Game.changeWindow(new BankingWindow());
            }
        }).seed(10));

        getContents().add(lineContents);


        VirtualLineContents cell = new VirtualLineContents();
        cell.getContents().add(new TextContent("Name"));
        cell.getContents().add(new TextContent("Status"));
        cell.getContents().add(new TextContent("Code"));

        getContents().add(cell);
        getContents().add(new TextContent("", -1, 0.2f, 2f, true));

        for (int a = 1; a < 10; a++) {
            cell = new VirtualLineContents();
            cell.getContents().add(new TextContent("Name " + a));
            cell.getContents().add(new ButtonContent("ok", new Runnable() {
                @Override
                public void run() {
                    Game.changeWindow(new BankingMainSlotWindow());
                }
            }).seed(6));
            cell.getContents().add(new TextContent("ax" + a));
            getContents().add(cell);

        }




        getContents().add(new SpacerContent(10));

    }
}
