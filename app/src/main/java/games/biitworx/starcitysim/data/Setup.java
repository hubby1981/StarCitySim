package games.biitworx.starcitysim.data;

import java.util.ArrayList;
import java.util.List;

import games.biitworx.starcitysim.data.helper.ObjectHelper;
import games.biitworx.starcitysim.scifi.PlanetSystem;

/**
 * Created by marcel.weissgerber on 09.05.2016.
 */
public class Setup {
    private List<Class> tables;
    public Setup(){
        tables=new ArrayList<>();

        tables.add(PlanetSystem.class);
    }

    public List<String> getCreateTables(){
        List<String> result =new ArrayList<>();
        for(Class c : tables){
            String statement =ObjectHelper.createTableStatement(c);
            if(statement!=null)
                result.add(statement);
        }
        return result;
    }
    public List<String> getDropTables(){
        List<String> result =new ArrayList<>();
        for(Class c : tables){
            String statement =ObjectHelper.createDropTableStatement(c);
            if(statement!=null)
                result.add(statement);
        }
        return result;
    }
}
