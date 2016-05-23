package games.biitworx.starcitysim.scifi.planet.rock;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;

import java.util.Random;

import games.biitworx.starcitysim.scifi.RandomRange;

/**
 * Created by marcel.weissgerber on 20.05.2016.
 */
public class RockPlanetTerrain {
    public static int TRANS = 255;
    public static int ROCK_BACK_COLOR_001 = Color.argb(TRANS, 50, 45, 30);
    public static int ROCK_BACK_COLOR_002 = Color.argb(TRANS, 70, 40, 0);
    public static int ROCK_BACK_COLOR_003 = Color.argb(TRANS, 10, 30, 40);
    public static int ROCK_BACK_COLOR_004 = Color.argb(TRANS, 45, 60, 65);
    public static int ROCK_BACK_COLOR_005 = Color.argb(TRANS, 10, 30, 40);
    public static int ROCK_BACK_COLOR_006 = Color.argb(TRANS, 15, 40, 45);
    public static int ROCK_BACK_COLOR_007 = Color.argb(TRANS, 50, 50, 50);
    public static int ROCK_BACK_COLOR_008 = Color.argb(TRANS, 40, 50, 50);
    public static int ROCK_BACK_COLOR_009 = Color.argb(TRANS, 20, 20, 20);


    public static void init(int trans){
        ROCK_BACK_COLOR_001 = Color.argb(trans, 50, 45, 30);
        ROCK_BACK_COLOR_002 = Color.argb(trans, 70, 40, 0);
        ROCK_BACK_COLOR_003 = Color.argb(trans, 10, 30, 40);
        ROCK_BACK_COLOR_004 = Color.argb(trans, 45, 60, 65);
        ROCK_BACK_COLOR_005 = Color.argb(trans, 10, 30, 40);
        ROCK_BACK_COLOR_006 = Color.argb(trans, 15, 40, 45);
        ROCK_BACK_COLOR_007 = Color.argb(trans, 50, 50, 50);
        ROCK_BACK_COLOR_008 = Color.argb(trans, 40, 50, 50);
        ROCK_BACK_COLOR_009 = Color.argb(trans, 20, 20, 20);
    }


    public static int getColor() {
        int color = RandomRange.getRandom(1, 10);
        if (color == 2) return ROCK_BACK_COLOR_002;
        if (color == 3) return ROCK_BACK_COLOR_003;
        if (color == 4) return ROCK_BACK_COLOR_004;
        if (color == 5) return ROCK_BACK_COLOR_005;
        if (color == 6) return ROCK_BACK_COLOR_006;
        if (color == 7) return ROCK_BACK_COLOR_007;
        if (color == 8) return ROCK_BACK_COLOR_008;
        if (color == 9) return ROCK_BACK_COLOR_009;

        return ROCK_BACK_COLOR_001;
    }

    public static int getAltColor(int color) {
        int result = getColor();
        while (result == color)
            result = getColor();
        return result;
    }



    public static Bitmap applyFleaEffect(Bitmap source, int percentNoise,int color) {
        // get source image size
        int width = source.getWidth();
        int height = source.getHeight();
        int[] pixels = new int[width * height];
        // get pixel array from source
        source.getPixels(pixels, 0, width, 0, 0, width, height);
        // create a random object
        Random random = new Random();

        int index = 0;
        // Note: Declare the c and randColor variables outside of the for loops

        // iterate through pixels
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                if (random.nextInt(101) < percentNoise) {
                    // Skip this iteration a certain percentage of the time
                    continue;
                }
                // get current index in 2D-matrix
                index = y * width + x;
                // get random color


                pixels[index] |= color;
            }
        }
        Bitmap bmOut = Bitmap.createBitmap(width, height, source.getConfig());
        bmOut.setPixels(pixels, 0, width, 0, 0, width, height);
        return bmOut;
    }
}
