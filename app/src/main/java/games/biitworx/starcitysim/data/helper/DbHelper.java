package games.biitworx.starcitysim.data.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marcel.weissgerber on 09.05.2016.
 */
public class DbHelper extends SQLiteOpenHelper {
    private final static String DBNAME="starcity";
    public DbHelper(Context context) {
        super(context, DBNAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.beginTransaction();

        db.endTransaction();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
