package games.biitworx.starcitysim.window.views;

import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.ButtonContent;
import games.biitworx.starcitysim.window.content.ProgressContent;
import games.biitworx.starcitysim.window.content.SpacerContent;

/**
 * Created by marce_000 on 03.05.2016.
 */
public class SettingsWindow extends Window {
    public SettingsWindow() {
        super(T.get(R.string.settings_window_title));
        getContents().add(new SpacerContent(1));
        getContents().add(new ProgressContent());
        getContents().add(new SpacerContent(1));

        getContents().add(new ButtonContent(T.get(R.string.overlay_menu_main),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}
