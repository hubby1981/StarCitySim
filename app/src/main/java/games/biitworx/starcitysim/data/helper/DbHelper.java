package games.biitworx.starcitysim.data.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import games.biitworx.starcitysim.data.BaseDataObject;
import games.biitworx.starcitysim.data.DbReference;
import games.biitworx.starcitysim.data.Setup;

/**
 * Created by marcel.weissgerber on 09.05.2016.
 */
public class DbHelper extends SQLiteOpenHelper {
    private final static String DBNAME = "starcity";
    private final static int version = 18;

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

    public String insert(Object object) {
        SQLiteDatabase db = get();

        if (db != null && db.isOpen()) {
            String st = ObjectHelper.createInsertStatement(object);

            if (st != null) {

                db.execSQL(st);
                HashMap<String, DbReference> ref = ObjectHelper.getReferencesEx(object.getClass());
                if (ref.size() > 0) {
                    for (Map.Entry<String, DbReference> e : ref.entrySet()) {
                        Field f = ObjectHelper.getDeclaredFieldByName(object.getClass(), e.getKey());
                        if (f != null) {
                            f.setAccessible(true);
                            try {
                                List<Object> items = (List<Object>) f.get(object);
                                if (items != null) {
                                    for (Object bo : items) {
                                        String id = insert(bo);
                                    }
                                }
                            } catch (IllegalAccessException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return ((BaseDataObject) object).getUID().toString();
    }

    public <T> List<T> getData(Class<T> clazz) {


        return null;
    }
}
