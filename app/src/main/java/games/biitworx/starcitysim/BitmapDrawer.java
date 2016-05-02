package games.biitworx.starcitysim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by marcel.weissgerber on 21.04.2016.
 */
public class BitmapDrawer {


    public static Rect drawImage(Bitmap bitmap, Canvas canvas, Rect rect, Paint painter, boolean recycle) {

        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, painter);
       /* if(recycle) {
            bitmap.recycle();
            bitmap = null;
        }*/
        return rect;
    }

    public static void drawImage(Bitmap bitmap, Canvas canvas, Rect rect, Paint painter, boolean recycle, int padding) {
        padding = rect.width() / padding;
        rect = new Rect(rect.left + padding, rect.top + padding, rect.right - padding, rect.bottom - padding);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, painter);
       /* if(recycle) {
            bitmap.recycle();
            bitmap = null;
        }*/
    }
}
