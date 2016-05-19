package games.biitworx.starcitysim.scifi;

/**
 * Created by marcel.weissgerber on 18.05.2016.
 */
public class PlanetConst {


    public static int GAS_PLANETS = 40;
    public static int ROCK_PLANETS = 66;
    public static int ICE_PLANETS = 86;
    public static int ROCK_ICE_PLANETS = 100;

    public static float MIN_PCM = 0.1f; //Max Core Mass
    public static float MAX_PCM = 3.0f; //Max Core Mass
    public static float MIN_PST = 1.0f; //Min Surface Thickness
    public static float MAX_PST = 5.0f; //Max Surface Thickness
    public static float MIN_PAT = 2.0f; //Min Atmosphere Thickness
    public static float MAX_PAT = 5.0f; //Max Atmosphere Thickness

    public static float MIN_PTI = -1.5f; //Min Ice Planet Temp
    public static float MAX_PTI = -50.0f; //Max Ice Planet Temp

    public static float MIN_PTR = -4f; //Min Rock Planet Temp
    public static float MAX_PTR = -60.5f; //Max Rock Planet Temp

    public static float MIN_PTG = 30.5f; //Min Gas Planet Temp
    public static float MAX_PTG = -180.5f; //Max Gas Planet Temp

    public static float MIN_PTIR = -8f; //Min Ice Rock Planet Temp
    public static float MAX_PTIR = -18f; //Max Ice Rock Temp


    public static int METER = 1000;


    public static float MIN_PFM = 1.1f; //Min Meter Radius 1000 * Factor = Radius
    public static float MAX_PFM = 4.9f; // Maximum Meter Radius

    public static float MIN_PSR = 0.1f; //Min Self Rotation 1 = 1 Galactic Day
    public static float MAX_PSR = 1.0f; //Max Self Rotation


    public static int MIN_COLOR_ICE = 150;
    public static int MAX_COLOR_ICE = 250;

    public static int MIN_COLOR_ROCK = 100;
    public static int MAX_COLOR_ROCK = 200;

    public static int MIN_COLOR_GAS = 100;
    public static int MAX_COLOR_GAS = 250;
}
