package games.biitworx.starcitysim.window.views;

import android.graphics.Color;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.basic.MenuCounter;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.content.SpacerContent;
import games.biitworx.starcitysim.window.content.TextContent;

/**
 * Created by marcel.weissgerber on 27.04.2016.
 */
public class DiplomacyWindow extends Window {
    public DiplomacyWindow() {
        super(T.get(R.string.window_diplomacy_title));

        //getContents().add(new TextContent("Select a action you want to perform"));

        getContents().add(new MenuItemContent(null,  B.get( R.drawable.relationsback), T.get(R.string.window_diplomacy_relations_title), T.get(R.string.window_diplomacy_relations_desc), MenuCounter.diplomacyCounter.relations, Colors.back001));

        getContents().add(new MenuItemContent(null,  B.get( R.drawable.warback), T.get(R.string.window_diplomacy_war_title), T.get(R.string.window_diplomacy_war_desc), MenuCounter.diplomacyCounter.war, Colors.back001));

        getContents().add(new MenuItemContent(null, B.get( R.drawable.menuback), T.get(R.string.window_menu_title),T.get(R.string.window_menu_desc),MenuCounter.menu.concat(" ").concat(T.get(R.string.items_count)), Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}
