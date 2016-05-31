package games.biitworx.starcitysim.window.views.setup;

import java.util.ArrayList;
import java.util.List;

import games.biitworx.starcitysim.Colors;
import games.biitworx.starcitysim.R;
import games.biitworx.starcitysim.TE;
import games.biitworx.starcitysim.window.Window;
import games.biitworx.starcitysim.window.content.ButtonContent;
import games.biitworx.starcitysim.window.content.ComboboxContent;
import games.biitworx.starcitysim.window.content.Content;
import games.biitworx.starcitysim.window.content.TextContent;

/**
 * Created by marcel.weissgerber on 18.05.2016.
 */
public class GameSetup extends Window {
    public GameSetup() {
        super(TE.get(R.string.window_game_setup_title));

        List<Content> a = new ArrayList<>();
        a.add(new TextContent("Papagei"));
        a.add(new TextContent("Huhn"));
        a.add(new TextContent("Pferd"));
        a.add(new TextContent("Fisch"));
        a.add(new TextContent("Hund"));
        a.add(new TextContent("Hase"));
        a.add(new TextContent("die Heilige Krabbe"));
        a.add(new TextContent("Spongebob"));
        a.add(new TextContent("Einhorn"));
        a.add(new TextContent("mich"));
        List<Content> b = new ArrayList<>();
        b.add(new TextContent("Pferd"));
        b.add(new TextContent("Castro"));
        b.add(new TextContent("Gandalf"));
        b.add(new TextContent("Kleines Mädchen"));
        b.add(new TextContent("Godzilla"));
        b.add(new TextContent("Gott"));
        b.add(new TextContent("Vader"));
        b.add(new TextContent("mich!"));
        List<Content> c = new ArrayList<>();
        c.add(new TextContent("mir egal"));
        c.add(new TextContent("*schief*"));
        c.add(new TextContent("Blumen"));
        c.add(new TextContent("Was??? der *piieeeep*"));
        c.add(new TextContent("kann nicht sein"));
        c.add(new TextContent("mich!!"));
        List<Content> d = new ArrayList<>();
        d.add(new TextContent("blau"));
        d.add(new TextContent("grün"));
        d.add(new TextContent("rot"));
        d.add(new TextContent("gelb"));
        d.add(new TextContent("violett"));
        d.add(new TextContent("schwarz"));
        d.add(new TextContent("weiss"));
        d.add(new TextContent("60 Arten von grau"));
        d.add(new TextContent("mich!!!"));
        List<Content> e = new ArrayList<>();
        e.add(new TextContent("Mensch"));
        e.add(new TextContent("Alien"));
        e.add(new TextContent("Beides"));
        e.add(new TextContent("mich!!!!"));
        List<Content> f = new ArrayList<>();
        f.add(new TextContent("Mensch"));
        f.add(new TextContent("Roboter"));
        f.add(new TextContent("Beides"));
        f.add(new TextContent("MICH!!!!!"));
        getContents().add(new ComboboxContent("Welches Tier mochtest du als Kind?","", Colors.back001, a));
        getContents().add(new ComboboxContent("In deinen Träumen bist du?","", Colors.back001, b));
        getContents().add(new ComboboxContent("Jemand mag dich nicht! Deine Reaktion?","",  Colors.back001, c));
        getContents().add(new ComboboxContent("Welche Farbe bist du?","", Colors.back001, d));
        getContents().add(new ComboboxContent("Mensch oder Alien?","", Colors.back001, e));
        getContents().add(new ComboboxContent("Mensch oder Roboter?","", Colors.back001, f));
        getContents().add(new ButtonContent("Fertig"));

    }
}
