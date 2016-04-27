package games.biitworx.starcitysim.window.views;

import android.graphics.Color;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
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
        super("Environment");


        getContents().add(new MenuItemContent(B.get2(R.drawable.info), B.get(R.drawable.infoback), "INFORMATIONS", "All race informations", "", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new InformationWindow());
                    }
                }));


        getContents().add(new MenuItemContent(B.get2(R.drawable.banking), B.get(R.drawable.bankingback), "BANKING", "Bank balance & credit line", "494.223 crd",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new BankingWindow());
                    }
                }));

        getContents().add(new MenuItemContent(B.get2(R.drawable.trading), B.get( R.drawable.tradingback),"Trading","Trade goods & minerals","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new TradingWindow());
                    }
                }));

        getContents().add(new MenuItemContent(B.get2(R.drawable.mining), B.get( R.drawable.miningback),"Mining","Extract & farming minerals","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MiningWindow());
                    }
                }));

        getContents().add(new MenuItemContent(B.get2(R.drawable.skill), B.get(R.drawable.skillback), "SKILL TREE", "Develop  race skills", "55 Points",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new SkillWindow());
                    }
                }));
        getContents().add(new MenuItemContent(B.get2(R.drawable.tech), B.get(R.drawable.techback), "TECH TREE", "Develop race technology", "100 Points",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new TechWindow());
                    }
                }));


        getContents().add(new MenuItemContent(B.get2(R.drawable.history), B.get(R.drawable.historyback), "HISTORY", "Important race events", "",Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new HistoryWindow());
                    }
                }));
        getContents().add(new MenuItemContent(null, B.get( R.drawable.menuback),"Menu","Open the main menu","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new MenuWindow());
                    }
                }));
    }
}
