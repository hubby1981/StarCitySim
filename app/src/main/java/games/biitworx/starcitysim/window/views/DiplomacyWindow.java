package games.biitworx.starcitysim.window.views;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.TE;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.basic.MenuCounter;
import games.biitworx.starcitysim.window.content.MenuItemContent;

/**
 * Created by marcel.weissgerber on 27.04.2016.
 */
public class DiplomacyWindow extends Window {
    public DiplomacyWindow() {
        super(TE.get(R.string.window_diplomacy_title));

        //getContents().add(new TextContent("Select a action you want to perform"));

        getContents().add(new MenuItemContent(null,  B.get( R.drawable.relationsback), TE.get(R.string.window_diplomacy_relations_title), TE.get(R.string.window_diplomacy_relations_desc), MenuCounter.diplomacyCounter.relations, Colors.back001));

        getContents().add(new MenuItemContent(null,  B.get( R.drawable.warback), TE.get(R.string.window_diplomacy_war_title), TE.get(R.string.window_diplomacy_war_desc), MenuCounter.diplomacyCounter.war, Colors.back001));

        getContents().add(new MenuItemContent(null, B.get( R.drawable.menuback), TE.get(R.string.window_menu_title), TE.get(R.string.window_menu_desc),MenuCounter.menu.concat(" ").concat(TE.get(R.string.items_count)), Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}
