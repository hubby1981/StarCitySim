package games.biitworx.starcitysim.window.views;

import android.graphics.Color;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.MenuItemContent;

/**
 * Created by marcel.weissgerber on 27.04.2016.
 */
public class OperationWindow extends Window {
    public OperationWindow() {
        super("Operation");

        getContents().add(new MenuItemContent(B.get(R.drawable.systems), B.get(R.drawable.systemsback), "SYSTEMS", "Your flagged systems", "4", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));

        getContents().add(new MenuItemContent(B.get(R.drawable.systems), B.get(R.drawable.warback), "FLEET", "Ships and positions", "4", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));

        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.logback), "LOG", "Last operations results", "3 / 4",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.taskback), "TASK", "Next steps in mission", "1 / 1",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.exploreback), "EXPLORATION", "Explore other systems", "1 / 1",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.settleback), "SETTLEMENT", "Settle other planets", "1 / 1",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get( R.drawable.systemsback),"Menu","Open the main menu","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}
