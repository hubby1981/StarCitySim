package games.biitworx.starcitysim.scifi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by marcel.weissgerber on 10.05.2016.
 */
public class NameGenerator {

    public ArrayList<String> syllables;

    public ArrayList<String> getSyllables() {
        ArrayList<String> result = new ArrayList<>();
        for (int x = 97; x <= 122; x++) {
            for (int xx = 97; xx <= 122; xx++) {
                String value = "";
                if (isNormalLetter(x) && x != xx && !isNormalLetter(xx)) {
                    value = Character.toString((char) x) + Character.toString((char) xx);
                    result.add(value);

                }
                if (!isNormalLetter(x) && x != xx && isNormalLetter(xx)) {
                    value = Character.toString((char) x) + Character.toString((char) xx);
                    result.add(value);

                }

                int u = RandomRange.getRandom(1, 5);
                if (u == 2) {
                    value += Character.toString((char) getNumber(97, 122, x));
                    result.add(value);

                }
                if (u == 3) {
                    value += Character.toString((char) getNumber(97, 122, xx)) + Character.toString((char) getNumber(97, 122, x));
                    result.add(value);

                }
            }
        }
        return result;
    }


    private boolean isNormalLetter(int letter) {
        return letter != 97 && letter != 101 && letter != 105 && letter != 117;
    }

    public String getRaceName() {
        return getName(RandomRange.getRandom(2, 3), RandomRange.getRandom(3, 5));
    }

    public String getSystemName() {
        return getName(2, 3);
    }

    public String getSunName() {
        return getName(1, 2);
    }

    private String getName(int min, int max) {
        if (syllables == null) syllables = getSyllables();
        max = RandomRange.getRandom(min, max);

        int len = RandomRange.getRandom(min, max);


        String result = "";
        int last = -1;
        for (int x = 0; x < len; x++) {
            last = getNumber(0, syllables.size() - 1, last);
            int sub = RandomRange.getRandom(1, 15);
            int a = RandomRange.getRandom(0, len - 1);
            sub = max <= 2 ? 0 : sub;

            result += x == a && sub > 9 && x + 1 < len ? syllables.get(last) + "'" : syllables.get(last);
        }

        String f = result.substring(0, 1);

        return (f.toUpperCase() + result.substring(1, result.length()));
    }

    public int getNumber(int min, int max, int not) {
        int result = not;

        while (result == not) {
            result = RandomRange.getRandom(min, max);
        }

        return result;
    }
}
