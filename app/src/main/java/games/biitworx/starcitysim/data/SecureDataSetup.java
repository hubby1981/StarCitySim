package games.biitworx.starcitysim.data;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import games.biitworx.starcitysim.Game;
import games.biitworx.starcitysim.scifi.PlanetSystem;
import games.biitworx.starcitysim.scifi.planet.PlanetData;

/**
 * Created by marce_000 on 28.05.2016.
 */
public class SecureDataSetup {


    List<Class> secureDataList = new ArrayList<>();


    public SecureDataSetup() {

        secureDataList.add(PlanetSystem.class);
        secureDataList.add(PlanetData.class);

    }

    public HashMap<String, List<Object>> getAll(SQLiteDatabase db) {
        HashMap<String, List<Object>> all = new HashMap<>();
        for (Class c : secureDataList) {
            all.put(c.getSimpleName(), Game.DATA.getData(c, db,true));
        }
        return all;
    }

    public void reInsertData(HashMap<String, List<Object>> all,SQLiteDatabase db) {
            for(Map.Entry<String,List<Object>> e:all.entrySet()){
                for(Object o: e.getValue()){
                    Game.DATA.insert(o,true,db);
                }
            }
    }
}
