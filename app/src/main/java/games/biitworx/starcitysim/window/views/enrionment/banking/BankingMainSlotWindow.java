package games.biitworx.starcitysim.window.views.enrionment.banking;

import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
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
        super( T.get(R.string.window_environment_banking_item0_title));
        getContents().add(new SpacerContent(1));
        getContents().add(new TextContent("",0.1f,1f,true));
        getContents().add(new TextContent(T.get(R.string.window_environment_banking_item0_window_header)));
        getContents().add(new TextContent("",0.2f,1f,true));
        getContents().add(new TextContent("+ 3.454.322 crd",1f,1.5f));
        getContents().add(new TextContent("",0.1f,1f,true));
        getContents().add(new TextContent("- 212.221 crd",1f,1.5f));

        getContents().add(new SpacerContent(2));
        getContents().add(new ButtonContent(T.get(R.string.content_banking_transaction_send), new Runnable() {
            @Override
            public void run() {
                Game.changeWindow(new ShipyardWindow());
            }
        }));
        getContents().add(new SpacerContent(0.5f));
        getContents().add(new ButtonContent(T.get(R.string.window_environment_banking_title), new Runnable() {
            @Override
            public void run() {
                Game.changeWindow(new BankingWindow());
            }
        }));
    }
}
