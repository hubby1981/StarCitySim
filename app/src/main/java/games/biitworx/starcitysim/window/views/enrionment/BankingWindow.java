package games.biitworx.starcitysim.window.views.enrionment;

import java.util.ArrayList;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.TE;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.basic.MenuCounter;
import games.biitworx.starcitysim.window.content.ButtonContent;
import games.biitworx.starcitysim.window.content.ComboboxContent;
import games.biitworx.starcitysim.window.content.Content;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.content.SpacerContent;
import games.biitworx.starcitysim.window.content.TextContent;
import games.biitworx.starcitysim.window.views.EnvironmentWindow;
import games.biitworx.starcitysim.window.views.MenuWindow;
import games.biitworx.starcitysim.window.views.enrionment.banking.BankingMainSlotWindow;
import games.biitworx.starcitysim.window.views.production.ShipyardWindow;

/**
 * Created by marce_000 on 27.04.2016.
 */
public class BankingWindow extends Window {
    public BankingWindow() {
        super(TE.get(R.string.window_environment_banking_title), TE.get(R.string.window_environment_banking_hint));
        setOverlayWindow(new BankingOverlayWindow());
        getContents().add(new MenuItemContent(null, B.get(R.drawable.bankingback), TE.get(R.string.window_environment_banking_item0_title), TE.get(R.string.window_environment_banking_item0_description), "", Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new BankingMainSlotWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get(R.drawable.bankingback), TE.get(R.string.window_environment_banking_item1_title), TE.get(R.string.window_environment_banking_item1_description), "", Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));

        ArrayList<Content> list = new ArrayList<>();

        list.add(new TextContent(TE.get(R.string.content_banking_selection_value0)));
        list.add(new TextContent(TE.get(R.string.content_banking_selection_value1)));
        list.add(new TextContent(TE.get(R.string.content_banking_selection_value2)));


        getContents().add(new ComboboxContent(TE.get(R.string.content_banking_selection),"",Colors.back001,list));
        getContents().add(new ButtonContent(TE.get(R.string.content_banking_add_slot), new Runnable() {
            @Override
            public void run() {
                Game.changeWindow(new ShipyardWindow());
            }
        }));
        getContents().add(new SpacerContent(1));

        getContents().add(new MenuItemContent(null, B.get(R.drawable.bankingback), TE.get(R.string.window_environment_title), TE.get(R.string.window_environment_desc), MenuCounter.environment.concat(" ").concat(TE.get(R.string.items_count)), Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new EnvironmentWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get(R.drawable.menuback), TE.get(R.string.window_menu_title), TE.get(R.string.window_menu_desc), MenuCounter.menu.concat(" ").concat(TE.get(R.string.items_count)), Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}