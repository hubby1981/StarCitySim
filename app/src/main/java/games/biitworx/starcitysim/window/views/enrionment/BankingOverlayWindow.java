package games.biitworx.starcitysim.window.views.enrionment;

import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.W;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.ButtonContent;
import games.biitworx.starcitysim.window.content.SpacerContent;
import games.biitworx.starcitysim.window.views.MenuWindow;

/**
 * Created by marce_000 on 03.05.2016.
 */
public class BankingOverlayWindow extends Window {
    public BankingOverlayWindow() {
        super("",T.get(R.string.window_menu_hint));
        getContents().add(new SpacerContent(1));
        getContents().add(new ButtonContent(T.get(R.string.overlay_menu_back),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(W.getLast());
                    }
                }));
        getContents().add(new ButtonContent(T.get(R.string.content_banking_add_slot)));
        getContents().add(new SpacerContent(1));
        getContents().add(new ButtonContent(T.get(R.string.overlay_menu_main),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}
