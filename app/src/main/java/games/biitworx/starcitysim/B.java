package games.biitworx.starcitysim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by marce_000 on 26.04.2016.
 */
public class B {

    public static Bitmap get(int id){
        return BitmapFactory.decodeResource(Game.res,id);
    }

    public static Bitmap get2(int id){
        return null;
    }

}
