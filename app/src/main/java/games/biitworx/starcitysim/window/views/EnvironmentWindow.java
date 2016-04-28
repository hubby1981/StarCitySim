package games.biitworx.starcitysim.window.views;

import android.graphics.Color;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.T;
import games.biitworx.starcitysim.window.Window;
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
        super(T.get(R.string.window_environment_title));


        getContents().add(new MenuItemContent(null, B.get(R.drawable.infoback), T.get(R.string.window_environment_information_title), "All race informations", "", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new InformationWindow());
                    }
                }));


        getContents().add(new MenuItemContent(null, B.get(R.drawable.bankingback),T.get(R.string.window_environment_banking_title), "Bank balance & credit line", "494.223 crd",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new BankingWindow());
                    }
                }));

        getContents().add(new MenuItemContent(null, B.get( R.drawable.tradingback),T.get(R.string.window_environment_trading_title),"Trade goods & minerals","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new TradingWindow());
                    }
                }));

        getContents().add(new MenuItemContent(null, B.get( R.drawable.miningback),T.get(R.string.window_environment_mining_title),"Extract & farming minerals","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MiningWindow());
                    }
                }));

        getContents().add(new MenuItemContent(null, B.get(R.drawable.skillback), T.get(R.string.window_environment_skill_title), "Develop  race skills", "55 Points",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new SkillWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get(R.drawable.techback), T.get(R.string.window_environment_tech_title), "Develop race technology", "100 Points",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new TechWindow());
                    }
                }));


        getContents().add(new MenuItemContent(null, B.get(R.drawable.historyback),T.get(R.string.window_environment_history_title), "Important race events", "",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new HistoryWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get( R.drawable.menuback),T.get(R.string.window_menu_title),"Open the main menu","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}
