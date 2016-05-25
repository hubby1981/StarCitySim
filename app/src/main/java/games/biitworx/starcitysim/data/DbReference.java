package games.biitworx.starcitysim.data;

import java.util.HashMap;

/**
 * Created by marcel.weissgerber on 25.05.2016.
 */
public @interface DbReference {

    String tableA();
    String tableB();
    Class items();
}
