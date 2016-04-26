package games.biitworx.starcitysim.window;

import android.graphics.Color;

import games.biitworx.starcitysim.Game;

/**
 * Created by marce_000 on 25.04.2016.
 */
public class MenuWindow extends Window {
    public MenuWindow() {
        super("Menu");
        getContents().add(new TextContent("Select a action you want to performe"));

        getContents().add(new MenuItemContent(Game.BANKING, Game.BANKINGBACK, "BANKING", "Environment", "494.223 crd", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(Game.SHIPYARD,Game.SHIPYARDBACK,"SHIPYARD","Production","10 / 20", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(Game.SYSTEMS, Game.SYSTEMSBACK, "SYSTEMS", "Environment", "4", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(Game.RELATIONS, Game.RELATIONSBACK, "RELATIONS", "Diplomacy", "12 | 4 | 2", Color.argb(175, 30, 90, 150)));

        getContents().add(new MenuItemContent(Game.LAB, Game.LABBACK, "LABS", "Science", "3 / 4", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(Game.SETTLE, Game.SETTLEBACK, "SETTLEMENT", "Science", "1 / 1", Color.argb(175, 30, 90, 150)));


    }
}
