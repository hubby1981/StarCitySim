package games.biitworx.starcitysim.window.views.enrionment;

import android.graphics.Color;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.basic.MenuCounter;
import games.biitworx.starcitysim.window.content.ButtonContent;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.content.SpacerContent;
import games.biitworx.starcitysim.window.views.EnvironmentWindow;
import games.biitworx.starcitysim.window.views.MenuWindow;

/**
 * Created by marce_000 on 27.04.2016.
 */
public class BankingWindow extends Window {
    public BankingWindow() {
        super(T.get(R.string.window_environment_banking_title));
        setOverlayWindow(new BankingOverlayWindow());
        getContents().add(new MenuItemContent(null, B.get(R.drawable.bankingback), T.get(R.string.window_environment_banking_item0_title), T.get(R.string.window_environment_banking_item0_description), "", Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));
        getContents().add(new MenuItemContent(null, B.get(R.drawable.bankingback), T.get(R.string.window_environment_banking_item1_title), T.get(R.string.window_environment_banking_item1_description), "", Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));
        getContents().add(new SpacerContent(1, true));

        getContents().add(new ButtonContent(T.get(R.string.content_banking_add_slot)));
        getContents().add(new SpacerContent(1, true));

        getContents().add(new MenuItemContent(null, B.get(R.drawable.bankingback), T.get(R.string.window_environment_title), T.get(R.string.window_environment_desc), MenuCounter.environment.concat(" ").concat(T.get(R.string.items_count)), Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new EnvironmentWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get(R.drawable.menuback), T.get(R.string.window_menu_title), T.get(R.string.window_menu_desc), MenuCounter.menu.concat(" ").concat(T.get(R.string.items_count)), Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}