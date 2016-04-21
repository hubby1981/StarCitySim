package games.biitworx.starcitysim.window;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by marce_000 on 21.04.2016.
 */
public class Contents {
    private ArrayList<Content> items=new ArrayList<>();

    public int getMaxLine(){

        int result = 1;

        for(Content c : items){
            result = c.getLineHeight();
        }
        return result;
    }

    public void add(Content content){
        items.add(content);
    }
}
