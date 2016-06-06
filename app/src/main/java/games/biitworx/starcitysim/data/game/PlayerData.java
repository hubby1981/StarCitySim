package games.biitworx.starcitysim.data.game;

import games.biitworx.starcitysim.data.BaseDataObject;
import games.biitworx.starcitysim.data.DbField;
import games.biitworx.starcitysim.data.DbTable;

/**
 * Created by marce_000 on 29.05.2016.
 */
@DbTable
public class PlayerData extends BaseDataObject {
    @DbField
    private String name;
    @DbField
    private int day;
    @DbField
    private int month;
    @DbField
    private int year;
    @DbField
    private int race;



    @Override
    protected void imported() {

    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
}
