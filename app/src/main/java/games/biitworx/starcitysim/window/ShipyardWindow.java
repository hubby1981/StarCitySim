package games.biitworx.starcitysim.window;

/**
 * Created by marcel.weissgerber on 22.04.2016.
 */
public class ShipyardWindow extends Window {
    public ShipyardWindow() {
        super("Shipyard");
        for (int i = 1; i < 100; i++)
            getContents().add(new TextContent("All Ships in Shipyard " + i));

    }
}
