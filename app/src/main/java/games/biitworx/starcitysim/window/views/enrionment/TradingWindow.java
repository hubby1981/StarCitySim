package games.biitworx.starcitysim.window.views.enrionment;

import android.graphics.Color;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.views.EnvironmentWindow;

/**
 * Created by marce_000 on 27.04.2016.
 */
public class TradingWindow extends Window {
    public TradingWindow() {
        super(T.get(R.string.window_environment_trading_title));
        getContents().add(new MenuItemContent(null, B.get( R.drawable.bankingback), T.get(R.string.window_environment_title),T.get(R.string.window_environment_desc),"7 items", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new EnvironmentWindow());
                    }
                }));
    }
}