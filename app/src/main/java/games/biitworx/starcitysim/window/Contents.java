package games.biitworx.starcitysim.window;

import android.graphics.Canvas;

import java.util.ArrayList;

import games.biitworx.starcitysim.MenuRects;
import games.biitworx.starcitysim.window.content.Content;

/**
 * Created by marce_000 on 21.04.2016.
 */
public class Contents {
    private ArrayList<Content> items=new ArrayList<>();

    public int getMaxLine(){

        int result = 1;

        for(Content c : items){
            result += c.getLineHeight(true);
        }
        return result;
    }

    public void add(Content content){
        items.add(content);
    }

    public void onDraw(Canvas canvas,int scroll){
        int y=0;

        for(Content c : items){

                y = c.onDraw(canvas,y,scroll);
        }
    }

    public ArrayList<Content> getItems(){
        return items;
    }
}
