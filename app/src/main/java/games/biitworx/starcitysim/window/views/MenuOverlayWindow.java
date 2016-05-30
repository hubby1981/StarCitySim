package games.biitworx.starcitysim.window.views;

import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.TE;
import games.biitworx.starcitysim.W;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.ButtonContent;
import games.biitworx.starcitysim.window.content.SpacerContent;

/**
 * Created by marce_000 on 25.04.2016.
 */
public class MenuOverlayWindow extends Window {
    public MenuOverlayWindow() {
        super("");
        getContents().add(new SpacerContent(1));
        getContents().add(new ButtonContent(TE.get(R.string.overlay_menu_back),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(W.getLast());
                    }
                }));
        getContents().add(new ButtonContent(TE.get(R.string.overlay_menu_settings),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new SettingsWindow());
                    }
                }));


        getContents().add(new ButtonContent(TE.get(R.string.overlay_menu_save),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
        getContents().add(new ButtonContent(TE.get(R.string.overlay_menu_shop),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new SettingsWindow());
                    }
                }));
        getContents().add(new ButtonContent(TE.get(R.string.overlay_menu_help),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new SettingsWindow());
                    }
                }));

        getContents().add(new ButtonContent(TE.get(R.string.overlay_menu_rate),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));

        getContents().add(new ButtonContent(TE.get(R.string.overlay_menu_share),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
        getContents().add(new SpacerContent(1));
        getContents().add(new ButtonContent(TE.get(R.string.overlay_menu_main),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));


    }
}
