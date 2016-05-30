package games.biitworx.starcitysim.scifi.galactic;

/**
 * Created by marce_000 on 30.05.2016.
 */
public class SpeedConst {

    public static final int KILOMETERS = 1000;
    public static final long LIGHTSPEED = KILOMETERS * 300;

    public static final long LIGHTDAY = TimeConst.SECONDS_PER_DAY*LIGHTSPEED;
    public static final long LIGHTMONTH = LIGHTDAY*TimeConst.DAYS;
    public static final long LIGHTYEAR = LIGHTMONTH*TimeConst.MONTHS;
}
