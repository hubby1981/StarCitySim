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

/**
 * Created by marcel.weissgerber on 27.04.2016.
 */
public class ScienceWindow extends Window {
    public ScienceWindow() {
        super(TE.get(R.string.window_science_title));



        getContents().add(new MenuItemContent(null, B.get(R.drawable.labback), TE.get(R.string.window_science_labs_title), TE.get(R.string.window_science_labs_desc), MenuCounter.scienceCounter.labs, Colors.back001));
        getContents().add(new MenuItemContent(null,  B.get( R.drawable.settleback), TE.get(R.string.window_science_settle_title), TE.get(R.string.window_science_settle_desc), MenuCounter.scienceCounter.settle, Colors.back001));
        getContents().add(new MenuItemContent(null,  B.get( R.drawable.exploreback), TE.get(R.string.window_science_explore_title), TE.get(R.string.window_science_explore_desc), MenuCounter.scienceCounter.explore,Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ShipyardWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null,  B.get( R.drawable.dnaback), TE.get(R.string.window_science_dna_title), TE.get(R.string.window_science_dna_desc), MenuCounter.scienceCounter.dna,Colors.back001,
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
