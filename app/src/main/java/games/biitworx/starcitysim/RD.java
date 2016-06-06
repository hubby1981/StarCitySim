package games.biitworx.starcitysim;

import android.content.res.Resources;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import games.biitworx.starcitysim.scifi.planet.PlanetSurface;

/**
 * Created by marce_000 on 29.05.2016.
 */
public class RD {

    public static List<String> rock = new ArrayList<>();
    public static List<String> gas = new ArrayList<>();
    public static List<String> sun = new ArrayList<>();
    public static List<String> water = new ArrayList<>();
    public static List<String> gras = new ArrayList<>();
    public static List<String> ice = new ArrayList<>();
    public static List<String> moon = new ArrayList<>();
    public static List<String> cloud = new ArrayList<>();

    static {

        rock = getRes("rock");
        gas = getRes("gas");
        sun = getRes("sun");
        water = getRes("water");
        gras = getRes("gras");
        ice = getRes("ice");
        cloud = getRes("cloud");

        moon.addAll(rock);
        moon.addAll(ice);
        moon.addAll(gras);

    }

    private static List<String> getRes(String name) {
        List<String> result = new ArrayList<>();
        Field[] drawables = games.biitworx.starcitysim.R.drawable.class.getFields();
        for (Field f : drawables) {
            if (f.getName().contains(name))
                try {
                    result.add(f.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return result;
    }

    public static int getMax(PlanetSurface surface) {
        switch (surface) {
            case ROCK:
                return rock.size();
            case ICE:
                return ice.size();

            case ICE_ROCK:
                return gras.size();
            case GAS:
                return gas.size();
            case SUN:
                return sun.size();
            case MOON:
                return moon.size();

        }
        return 0;
    }

    public static int getMaxCloud() {

        return cloud.size();
    }

    public static String getCloudName(int index){
        List<String> data =cloud;
        if(index<0)return "";
        if (data.size() > index)
            return data.get(index);
        return data.size() > 0 ? data.get(0) : "cloud001";
    }

    public static String getName(PlanetSurface surface, int index) {
        if(index<0)return "";

        List<String> data = new ArrayList<>();
        switch (surface) {
            case ROCK:
                data = rock;
                break;
            case ICE:
                data = ice;
                break;

            case ICE_ROCK:
                data = gras;
                break;

            case GAS:
                data = gas;
                break;

            case SUN:
                data = sun;
                break;

            case MOON:
                data = moon;

        }
        if (data.size() > index)
            return data.get(index);
        return data.size() > 0 ? data.get(0) : "rock001";
    }

    public static int getResIdByName(String name) {
        try {
            Field drawables = R.drawable.class.getDeclaredField(name);
            try {
                return (int) drawables.get(R.drawable.class.newInstance());
            } catch (IllegalAccessException e) {

            } catch (InstantiationException e) {

            }
        } catch (NoSuchFieldException e) {

        }

        return 1;
    }
}
