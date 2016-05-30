package games.biitworx.starcitysim.window.views;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.TE;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.basic.MenuCounter;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.views.production.ShipyardWindow;
import games.biitworx.starcitysim.window.views.systems.SystemsWindow;

/**
 * Created by marcel.weissgerber on 27.04.2016.
 */
public class OperationWindow extends Window {
    public OperationWindow() {
        super(TE.get(R.string.window_operation_title));

        getContents().add(new MenuItemContent(null, B.get(R.drawable.systemsback), TE.get(R.string.window_operations_systems_title), TE.get(R.string.window_operations_systems_desc), MenuCounter.operationCounter.systems, Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new SystemsWindow());
                    }
                }));

        getContents().add(new MenuItemContent(null, B.get(R.drawable.fleetback), TE.get(R.string.window_operations_fleet_title), TE.get(R.string.window_operations_fleet_desc),MenuCounter.operationCounter.fleet, Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));

        getContents().add(new MenuItemContent(null,  B.get( R.drawable.logback), TE.get(R.string.window_operations_log_title), TE.get(R.string.window_operations_log_desc),MenuCounter.operationCounter.log,Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null,  B.get( R.drawable.taskback), TE.get(R.string.window_operations_task_title), TE.get(R.string.window_operations_task_desc), MenuCounter.operationCounter.task,Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null,  B.get( R.drawable.exploreback), TE.get(R.string.window_operations_explore_title), TE.get(R.string.window_operations_explore_desc), MenuCounter.operationCounter.explore,Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null,  B.get( R.drawable.settleback), TE.get(R.string.window_operations_settle_title), TE.get(R.string.window_operations_settle_desc), MenuCounter.operationCounter.settle,Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));

        getContents().add(new MenuItemContent(null, B.get( R.drawable.menuback), TE.get(R.string.window_menu_title), TE.get(R.string.window_menu_desc), MenuCounter.menu.concat(" ").concat(TE.get(R.string.items_count)), Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}
