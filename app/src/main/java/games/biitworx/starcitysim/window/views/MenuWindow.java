package games.biitworx.starcitysim.window.views;

import android.graphics.Color;

import games.biitworx.starcitysim.B;
import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.window.content.MenuItemContent;
import games.biitworx.starcitysim.window.content.TextContent;
import games.biitworx.starcitysim.window.Window;

/**
 * Created by marce_000 on 25.04.2016.
 */
public class MenuWindow extends Window {
    public MenuWindow() {
        super("Menu");
        getContents().add(new TextContent("Select a action you want to performe"));
        getContents().add(new MenuItemContent(B.get(R.drawable.menu), B.get( R.drawable.bankingback),"Environment","Check & Manage your race","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new EnvironmentWindow());
                    }
                }));
        getContents().add(new MenuItemContent(B.get(R.drawable.menu), B.get( R.drawable.shipyardback),"Production","Build several objects","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ProductionWindow());
                    }
                }));
        getContents().add(new MenuItemContent(B.get(R.drawable.menu), B.get( R.drawable.relationsback),"Diplomacy","Relations to other races","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new DiplomacyWindow());
                    }
                }));
        getContents().add(new MenuItemContent(B.get(R.drawable.menu), B.get( R.drawable.labback),"Science","Research & Develop","", Color.argb(175, 30, 90, 150),
                new Runnable() {
                    @Override
                    public void run() {
                        Game.changeWindow(new ScienceWindow());
                    }
                }));
    }
}