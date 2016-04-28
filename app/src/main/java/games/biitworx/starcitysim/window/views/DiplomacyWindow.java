package games.biitworx.starcitysim.window.views;

import android.graphics.Color;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.content.TextContent;

/**
 * Created by marcel.weissgerber on 27.04.2016.
 */
public class DiplomacyWindow extends Window {
    public DiplomacyWindow() {
        super(T.get(R.string.window_diplomacy_title));

        //getContents().add(new TextContent("Select a action you want to perform"));

        getContents().add(new MenuItemContent(null,  B.get( R.drawable.relationsback), "RELATIONS", "Relations to other races", "12 | 4 | 2", Color.argb(175, 30, 90, 150)));

        getContents().add(new MenuItemContent(null,  B.get( R.drawable.warback), "WAR", "War with other races", "1 / 1", Color.argb(175, 30, 90, 150)));
        getContents().add(new MenuItemContent(null, B.get( R.drawable.menuback), T.get(R.string.window_menu_title),"Open the main menu","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}
