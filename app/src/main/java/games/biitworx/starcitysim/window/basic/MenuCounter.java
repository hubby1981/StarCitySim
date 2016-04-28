package games.biitworx.starcitysim.window.basic;

/**
 * Created by marce_000 on 28.04.2016.
 */
public class MenuCounter {

    public static String menu="5";
    public static String production="1";
    public static String diplomacy="2";
    public static String science="4";
    public static String operation="6";
    public static String environment="7";

    public static EnvironmentCounter environmentCounter=new EnvironmentCounter();
    public static ProductionCounter productionCounter=new ProductionCounter();
    public static DiplomacyCounter diplomacyCounter = new DiplomacyCounter();
    public static ScienceCounter scienceCounter = new ScienceCounter();
    public static OperationCounter operationCounter = new OperationCounter();

}
