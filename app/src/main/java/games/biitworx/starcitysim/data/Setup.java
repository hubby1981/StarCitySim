package games.biitworx.starcitysim.data;

import java.util.ArrayList;
import java.util.List;

import games.biitworx.starcitysim.data.helper.ObjectHelper;
import games.biitworx.starcitysim.scifi.PlanetSystem;
import games.biitworx.starcitysim.scifi.planet.PlanetData;

/**
 * Created by marcel.weissgerber on 09.05.2016.
 */
public class Setup {
    private List<Class> tables;
    public Setup(){
        tables=new ArrayList<>();

        tables.add(PlanetSystem.class);
        tables.add(PlanetData.class);

    }

    public List<String> getCreateTables(){
        List<String> result =new ArrayList<>();
        for(Class c : tables){
            String statement =ObjectHelper.createTableStatement(c);
            if(statement!=null)
                result.add(statement);
            List<String> refs = ObjectHelper.createReferenceTableStatement(c);
            for(String s:refs)
            if(s!=null)
                result.add(s);
        }
        return result;
    }
    public List<String> getDropTables(){
        List<String> result =new ArrayList<>();
        for(Class c : tables){
            String statement =ObjectHelper.createDropTableStatement(c);
            if(statement!=null)
                result.add(statement);
            List<String> refs = ObjectHelper.createDropReferenceTableStatement(c);
            for(String s:refs)
                if(s!=null)
                    result.add(s);
        }
        return result;
    }
}
