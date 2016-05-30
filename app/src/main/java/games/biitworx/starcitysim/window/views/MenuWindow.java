package games.biitworx.starcitysim.window.views;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.TE;
import games.biitworx.starcitysim.window.basic.MenuCounter;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.Window;

/**
 * Created by marce_000 on 25.04.2016.
 */
public class MenuWindow extends Window {
    public MenuWindow() {
        super(TE.get(R.string.window_menu_title), TE.get(R.string.window_menu_hint));
        getContents().add(new MenuItemContent(null, B.get( R.drawable.bankingback), TE.get(R.string.window_environment_title), TE.get(R.string.window_environment_desc), MenuCounter.environment.concat(" ").concat(TE.get(R.string.items_count)),  Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new EnvironmentWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get( R.drawable.shipyardback), TE.get(R.string.window_production_title), TE.get(R.string.window_production_desc),MenuCounter.production.concat(" ").concat(TE.get(R.string.item_count)), Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ProductionWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get( R.drawable.relationsback), TE.get(R.string.window_diplomacy_title), TE.get(R.string.window_diplomacy_desc),MenuCounter.diplomacy.concat(" ").concat(TE.get(R.string.items_count)), Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new DiplomacyWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get( R.drawable.labback), TE.get(R.string.window_science_title), TE.get(R.string.window_science_desc),MenuCounter.science.concat(" ").concat(TE.get(R.string.items_count)), Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ScienceWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get( R.drawable.operationback), TE.get(R.string.window_operation_title), TE.get(R.string.window_operation_desc),MenuCounter.operation.concat(" ").concat(TE.get(R.string.items_count)), Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new OperationWindow());
                    }
                }));
    }
}
