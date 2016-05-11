package games.biitworx.starcitysim.scifi;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by marcel.weissgerber on 10.05.2016.
 */
public class NameGenerator {

    public ArrayList<String> syllables;

    public ArrayList<String> getSyllables() {
        ArrayList<String> result = new ArrayList<>();
        for (int x = 97; x <= 122; x++) {
            for (int xx = 97; xx <= 122; xx++) {
                if (isNormalLetter(x) && x != xx && !isNormalLetter(xx)) {
                    result.add(Character.toString((char) x) + Character.toString((char) xx));
                }
                if (!isNormalLetter(x) && x != xx && isNormalLetter(xx)) {
                    result.add(Character.toString((char) x) + Character.toString((char) xx));
                }
            }
        }
        return result;
    }


    private boolean isNormalLetter(int letter) {
        return letter != 97 && letter != 101 && letter != 105 && letter != 117;
    }

    public String getRaceName() {
        return getName(2, 4);
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
            int sub = RandomRange.getRandom(1, 10);
            int a = RandomRange.getRandom(0, len - 1);
            sub = max <=2 ? 0 : sub;

            result += x == a && sub > 7 &&x+1<len ? syllables.get(last) + "'" : syllables.get(last);
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
