package games.biitworx.starcitysim.window;

import android.graphics.Color;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;

/**
 * Created by marce_000 on 25.04.2016.
 */
public class MenuWindow extends Window {
    public MenuWindow() {
        super("Menu");
        getContents().add(new TextContent("Select a action you want to performe"));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard), B.get(R.drawable.infoback), "INFORMATIONS", "Environment", "", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard), B.get(R.drawable.skillback), "SKILL TREE", "Environment", "", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard), B.get(R.drawable.techback), "TECH TREE", "Environment", "", Color.argb(175, 30, 90, 150)));

        getContents().add(new MenuItemContent(B.get(R.drawable.banking), B.get(R.drawable.bankingback), "BANKING", "Environment", "494.223 crd", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard), B.get( R.drawable.shipyardback),"SHIPYARD","Production","10 / 20", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));
        getContents().add(new MenuItemContent(B.get(R.drawable.systems),  B.get( R.drawable.systemsback), "SYSTEMS", "Environment", "4", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.relations),  B.get( R.drawable.relationsback), "RELATIONS", "Diplomacy", "12 | 4 | 2", Color.argb(175, 30, 90, 150)));

        getContents().add(new MenuItemContent(B.get(R.drawable.lab),  B.get( R.drawable.labback), "LABS", "Science", "3 / 4", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.lab),  B.get( R.drawable.settleback), "SETTLEMENT", "Science", "1 / 1", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.logback), "LOG", "Environment", "3 / 4", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.taskback), "TASK", "Environment", "1 / 1", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.exploreback), "EXPLORATION", "Environment", "1 / 1", Color.argb(175, 30, 90, 150)));

        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.warback), "WAR", "Diplomacy", "1 / 1", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard), B.get(R.drawable.historyback), "HISTORY", "Environment", "", Color.argb(175, 30, 90, 150)));


    }
}
