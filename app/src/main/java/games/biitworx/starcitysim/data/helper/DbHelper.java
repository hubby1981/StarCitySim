package games.biitworx.starcitysim.data.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import games.biitworx.starcitysim.data.BaseDataObject;
import games.biitworx.starcitysim.data.Setup;

/**
 * Created by marcel.weissgerber on 09.05.2016.
 */
public class DbHelper extends SQLiteOpenHelper {
    private final static String DBNAME = "starcity";
    private final static int version=18;

    public DbHelper(Context context) {
        super(context, DBNAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        createDb(db);

    }

    private void createDb(SQLiteDatabase db) {


        Setup s = new Setup();

        for (String st : s.getCreateTables())
            db.execSQL(st);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Setup s = new Setup();

        for (String st : s.getDropTables())
            db.execSQL(st);

        createDb(db);
    }


    public SQLiteDatabase get() {
        return getWritableDatabase();
    }

    public String insert(BaseDataObject object) {
        SQLiteDatabase db = get();

        if (db != null && db.isOpen()) {
            String st = ObjectHelper.createInsertStatement(object);
            if (st != null)
                db.execSQL(st);
        }
        return object.getUID().toString();
    }

    public <T> List<T> getData(Class<T> clazz){


        return null;
    }
}
