package games.biitworx.starcitysim;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by marcel.weissgerber on 22.04.2016.
 */
public class Fonts {

    public static Paint FONT;
   static{
       if(FONT==null) {
           FONT = new Paint();

           FONT.setColor(Color.argb(255, 255, 255, 255));


           FONT.setAntiAlias(true);
       }
    }
}
