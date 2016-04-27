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
public class DiplomacyWindow extends Window {
    public DiplomacyWindow() {
        super("Diplomacy");

        getContents().add(new TextContent("Select a action you want to performe"));

        getContents().add(new MenuItemContent(B.get(R.drawable.relations),  B.get( R.drawable.relationsback), "RELATIONS", "Diplomacy", "12 | 4 | 2", Color.argb(175, 30, 90, 150)));

        getContents().add(new MenuItemContent(B.get(R.drawable.shipyard),  B.get( R.drawable.warback), "WAR", "Diplomacy", "1 / 1", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(B.get(R.drawable.menu), B.get( R.drawable.systemsback),"Menu","","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}