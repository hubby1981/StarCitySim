package games.biitworx.starcitysim.window.views;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.TE;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.basic.MenuCounter;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.views.enrionment.BankingWindow;
import games.biitworx.starcitysim.window.views.enrionment.HistoryWindow;
import games.biitworx.starcitysim.window.views.enrionment.InformationWindow;
import games.biitworx.starcitysim.window.views.enrionment.MiningWindow;
import games.biitworx.starcitysim.window.views.enrionment.SkillWindow;
import games.biitworx.starcitysim.window.views.enrionment.TechWindow;
import games.biitworx.starcitysim.window.views.enrionment.TradingWindow;

/**
 * Created by marcel.weissgerber on 27.04.2016.
 */
public class EnvironmentWindow extends Window {
    public EnvironmentWindow() {
        super(TE.get(R.string.window_environment_title));


        getContents().add(new MenuItemContent(null, B.get(R.drawable.infoback), TE.get(R.string.window_environment_information_title), TE.get(R.string.window_environment_information_desc), MenuCounter.environmentCounter.information, Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new InformationWindow());
                    }
                }));


        getContents().add(new MenuItemContent(null, B.get(R.drawable.bankingback), TE.get(R.string.window_environment_banking_title), TE.get(R.string.window_environment_banking_desc), MenuCounter.environmentCounter.banking, Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new BankingWindow());
                    }
                }));

        getContents().add(new MenuItemContent(null, B.get( R.drawable.tradingback), TE.get(R.string.window_environment_trading_title), TE.get(R.string.window_environment_trading_desc),MenuCounter.environmentCounter.trading, Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new TradingWindow());
                    }
                }));

        getContents().add(new MenuItemContent(null, B.get( R.drawable.miningback), TE.get(R.string.window_environment_mining_title), TE.get(R.string.window_environment_mining_desc),MenuCounter.environmentCounter.mining, Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MiningWindow());
                    }
                }));

        getContents().add(new MenuItemContent(null, B.get(R.drawable.skillback), TE.get(R.string.window_environment_skill_title), TE.get(R.string.window_environment_skill_desc), MenuCounter.environmentCounter.skill, Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new SkillWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get(R.drawable.techback), TE.get(R.string.window_environment_tech_title), TE.get(R.string.window_environment_tech_desc), MenuCounter.environmentCounter.tech, Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new TechWindow());
                    }
                }));


        getContents().add(new MenuItemContent(null, B.get(R.drawable.historyback), TE.get(R.string.window_environment_history_title), TE.get(R.string.window_environment_history_desc), MenuCounter.environmentCounter.history, Colors.back001,
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new HistoryWindow());
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
