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
public class EnvironmentWindow extends Window {
    public EnvironmentWindow() {
        super("Environment");

        getContents().add(new TextContent("Select a action you want to perform."));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard), B.get(R.drawable.infoback), "INFORMATIONS", "Environment", "", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard), B.get(R.drawable.skillback), "SKILL TREE", "Environment", "", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard), B.get(R.drawable.techback), "TECH TREE", "Environment", "", Color.argb(175, 30, 90, 150)));

        getContents().add(new MenuItemContent(B.get(R.drawable.banking), B.get(R.drawable.bankingback), "BANKING", "Environment", "494.223 crd", Color.argb(175, 30, 90, 150)));

        getContents().add(new MenuItemContent(B.get(R.drawable.systems),  B.get( R.drawable.systemsback), "SYSTEMS", "Environment", "4", Color.argb(175, 30, 90, 150)));

        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.logback), "LOG", "Environment", "3 / 4", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.taskback), "TASK", "Environment", "1 / 1", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.exploreback), "EXPLORATION", "Environment", "1 / 1", Color.argb(175, 30, 90, 150)));

        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard), B.get(R.drawable.historyback), "HISTORY", "Environment", "", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.menu), B.get( R.drawable.systemsback),"Menu","","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}
