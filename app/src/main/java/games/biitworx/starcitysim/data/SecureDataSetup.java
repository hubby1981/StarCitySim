package games.biitworx.starcitysim.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.scifi.PlanetSystem;

/**
 * Created by marce_000 on 28.05.2016.
 */
public class SecureDataSetup {


    List<Class> secureDataList = new ArrayList<>();


    public SecureDataSetup() {

        secureDataList.add(PlanetSystem.class);
    }

    public HashMap<String, List<Object>> getAll() {
        HashMap<String, List<Object>> all = new HashMap<>();
        for (Class c : secureDataList) {
            all.put(c.getSimpleName(), Game.DATA.getData(c, Game.DATA.get()));
        }
        return all;
    }

    public void reInsertData(HashMap<String, List<Object>> all) {

    }
}
