package games.biitworx.starcitysim.window.views.enrionment.banking;

import android.graphics.Color;

import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.TE;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.ButtonContent;
import games.biitworx.starcitysim.window.content.SpacerContent;
import games.biitworx.starcitysim.window.content.TextContent;
import games.biitworx.starcitysim.window.views.enrionment.BankingWindow;
import games.biitworx.starcitysim.window.views.production.ShipyardWindow;

/**
 * Created by marcel.weissgerber on 09.05.2016.
 */
public class BankingMainSlotWindow extends Window {
    public BankingMainSlotWindow() {
        super(TE.get(R.string.window_environment_banking_item0_title));
        getContents().add(new SpacerContent(1));
        getContents().add(new TextContent("", -1, 0.1f, 1f, true));
        getContents().add(new TextContent(TE.get(R.string.window_environment_banking_item0_window_header)).centered(true));
        getContents().add(new TextContent("", -1, 0.2f, 1f, true));
        getContents().add(new TextContent("Alter Saldo: + 28.384.229 mil. crd", Color.argb(200, 50, 200, 50), 1f, 1.75f));
        getContents().add(new TextContent("", -1, 0.2f, 1f, true));

        for (int x = 1; x < 10; x++) {

            getContents().add(new TextContent("29391.7."+x+" # Überweisung Galaktische Bank", -1, 1, 2f));
            getContents().add(new TextContent(" + 3.454.322", Color.argb(200, 50, 200, 50), 1f, 1.75f));
            getContents().add(new TextContent("", -1, 0.2f, 1f, true));
            getContents().add(new TextContent("29391.7."+x+" # Überweisung Galaktische Bank", -1, 1, 2f));
            getContents().add(new TextContent(" + 3.454.322", Color.argb(200, 50, 200, 50), 1f, 1.75f));

            getContents().add(new TextContent("", -1, 0.2f, 1f, true));
            getContents().add(new TextContent("29391.7."+x+" # Überweisung Galaktische Bank", -1, 1, 2f));

            getContents().add(new TextContent(" + 3.454.322", Color.argb(200, 50, 200, 50), 1f, 1.75f));

            getContents().add(new TextContent("", -1, 0.1f, 1f, true));
            getContents().add(new TextContent("29391.8."+x+" # Forschung / Entwicklung Budget", -1, 1, 2f));

            getContents().add(new TextContent(" - 212.221", Color.argb(200, 200, 50, 50), 1f, 1.75f));
        }
        getContents().add(new TextContent("", -1, 0.2f, 1f, true));

        getContents().add(new TextContent("Neuer Saldo: + 31.321.000 mil. crd", Color.argb(200, 50, 200, 50), 1f, 1.75f));

        getContents().add(new SpacerContent(2));
        getContents().add(new ButtonContent(TE.get(R.string.content_banking_transaction_send), new Runnable() {
            @Override
            public void run() {
                Game.changeWindow(new ShipyardWindow());
            }
        }));
        getContents().add(new SpacerContent(0.5f));
        getContents().add(new ButtonContent(TE.get(R.string.window_environment_banking_title), new Runnable() {
            @Override
            public void run() {
                Game.changeWindow(new BankingWindow());
            }
        }));
        getContents().add(new SpacerContent(getContents().getItems().size() / 3));
    }
}
