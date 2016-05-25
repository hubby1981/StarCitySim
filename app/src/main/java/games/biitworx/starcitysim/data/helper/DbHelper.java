package games.biitworx.starcitysim.data.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import games.biitworx.starcitysim.data.BaseDataObject;
import games.biitworx.starcitysim.data.DbReference;
import games.biitworx.starcitysim.data.Setup;
import games.biitworx.starcitysim.scifi.PlanetSystem;
import games.biitworx.starcitysim.scifi.planet.PlanetSurface;

/**
 * Created by marcel.weissgerber on 09.05.2016.
 */
public class DbHelper extends SQLiteOpenHelper {
    private final static String DBNAME = "starcity";
    private final static int version = 26;

    public DbHelper(Context context) {
        super(context, DBNAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        createDb(db);

    }

    private void createDb(SQLiteDatabase db) {


        Setup s = new Setup();

        for (String st : s.getCreateTables()) {
            db.execSQL(st);
            //System.out.println(st);
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Setup s = new Setup();

        for (String st : s.getDropTables()) {
            db.execSQL(st);
            //System.out.println(st);

        }

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
                                        String st2 = "INSERT or replace INTO " + e.getKey() + " (parent,child) VALUES ('" + ((BaseDataObject) object).getUID().toString() + "','" +
                                                id + "')";
                                        db.execSQL(st2);
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

    public <T> List<T> getData(Class<T> clazz, SQLiteDatabase db2) {
        SQLiteDatabase db = db2 != null ? db2 : get();
        List<String> fields = ObjectHelper.getFieldsEx(clazz);
        List<T> result = new ArrayList<>();
        String table = ObjectHelper.getTableNameEx(clazz);
        if (fields != null && table != null && db != null && db.isOpen()) {

            String st = "SELECT #F FROM " + table;
            String ff = "";
            int index = 0;
            for (String f : fields) {
                ff += f;
                if (index < fields.size() - 1)
                    ff += ",";
                index++;
            }
            st = st.replace("#F", ff);

            Cursor cursor = db.rawQuery(st, null);
            while (cursor.moveToNext()) {
                T obj = null;
                try {
                    obj = clazz.newInstance();
                    result.add(obj);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (obj != null) {
                    for (String fd : cursor.getColumnNames()) {
                        String value = cursor.getString(cursor.getColumnIndex(fd));


                        Field fg = ObjectHelper.getDeclaredFieldByName(clazz, fd);
                        Object val = getObject(value, fg);
                        if (fg != null) {
                            fg.setAccessible(true);
                            try {
                                fg.set(obj, val);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }


                    }

                    loadReferences(clazz, db, obj);
                    ((BaseDataObject) obj).importedEx();
                }
            }
        }

        return result;
    }

    private Object getObject(String value, Field fg) {
        Object val;
        if (fg.getGenericType().equals(int.class)) {
            val = Integer.parseInt(value);
        } else if (fg.getGenericType().equals(float.class)) {
            val = Float.parseFloat(value);
        } else if (fg.getGenericType().equals(UUID.class)) {
            val = UUID.fromString(value);
        } else if (fg.getGenericType().equals(PlanetSurface.class)) {
            val = Enum.valueOf(PlanetSurface.class, value);
        } else {
            val = value;
        }
        return val;
    }

    private <T> void loadReferences(Class<T> clazz, SQLiteDatabase db, T obj) {
        HashMap<String, DbReference> ref = ObjectHelper.getReferencesEx(clazz);
        if (ref.size() > 0) {
            String refUid = ((BaseDataObject) obj).getUID().toString();
            for (Map.Entry<String, DbReference> e : ref.entrySet()) {
                String st2 = "SELECT parent,child FROM " + e.getKey() + " WHERE parent='" + refUid + "'";
                Class cls = e.getValue().items();
                List<Object> sub2 = new ArrayList<>();
                Cursor cursor2 = db.rawQuery(st2, null);
                while (cursor2.moveToNext()) {
                    String id = cursor2.getString(cursor2.getColumnIndex("child"));
                    sub2.add(getData(e.getValue().items(), db, id));
                }

                if (sub2 != null && sub2.size() > 0) {
                    Field fg2 = ObjectHelper.getDeclaredFieldByName(clazz, e.getKey());
                    if (fg2 != null) {
                        fg2.setAccessible(true);
                        try {
                            fg2.set(obj, sub2);
                        } catch (IllegalAccessException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public <T> T getData(Class<T> clazz, SQLiteDatabase db2, String id) {
        SQLiteDatabase db = db2 != null ? db2 : get();
        List<String> fields = ObjectHelper.getFieldsEx(clazz);
        T obj = null;
        try {
            obj = clazz.newInstance();
            ;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String table = ObjectHelper.getTableNameEx(clazz);
        if (fields != null && table != null && db != null && db.isOpen()) {

            String st = "SELECT #F FROM " + table + " WHERE uid='" + id + "'";
            String ff = "";
            int index = 0;
            for (String f : fields) {
                ff += f;
                if (index < fields.size() - 1)
                    ff += ",";
                index++;
            }
            st = st.replace("#F", ff);

            Cursor cursor = db.rawQuery(st, null);
            while (cursor.moveToNext()) {

                if (obj != null) {
                    for (String fd : cursor.getColumnNames()) {
                        String value = cursor.getString(cursor.getColumnIndex(fd));


                        Field fg = ObjectHelper.getDeclaredFieldByName(clazz, fd);
                        Object val = getObject(value, fg);

                        if (fg != null) {
                            fg.setAccessible(true);
                            try {
                                fg.set(obj, val);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }


                    }

                    loadReferences(clazz, db, obj);


                }
            }
        }
        ((BaseDataObject) obj).importedEx();
        return obj;
    }
}
