package games.biitworx.starcitysim.window.views;

import android.graphics.Color;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.content.TextContent;

/**
 * Created by marcel.weissgerber on 27.04.2016.
 */
public class ScienceWindow extends Window {
    public ScienceWindow() {
        super("Science");



        getContents().add(new MenuItemContent(B.get(R.drawable.lab), B.get(R.drawable.labback), "LABS", "Research new methods", "3 / 4", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.lab),  B.get( R.drawable.settleback), "SETTLEMENT", "Research more options", "1 / 1", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.exploreback), "EXPLORATION", "Research more options", "1 / 1",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.dnaback), "DNA", "Research race abilities", "1 / 1",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get( R.drawable.menuback),"Menu","Open the main menu","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}
