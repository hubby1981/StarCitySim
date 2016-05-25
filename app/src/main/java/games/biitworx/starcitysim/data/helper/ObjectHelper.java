package games.biitworx.starcitysim.data.helper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import games.biitworx.starcitysim.data.DbField;
import games.biitworx.starcitysim.data.DbTable;

/**
 * Created by marcel.weissgerber on 25.05.2016.
 */
public class ObjectHelper {

    public static String getTableName(Object object) {
        DbTable o = object.getClass().getAnnotation(DbTable.class);
        if (o != null)
            return o.name();
        return null;
    }


    public static String getTableNameEx(Class clazz) {
        DbTable o = (DbTable) clazz.getAnnotation(DbTable.class);
        if (o != null)
            return o.name();
        return null;
    }


    public static HashMap<String, String> getFields(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        HashMap<String, String> result = new HashMap<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(DbField.class)) {
                try {
                    f.setAccessible(true);
                    result.put(f.getName(), f.get(object).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static List<String> getFieldsEx(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        List<String> result = new ArrayList<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(DbField.class)) {
                result.add(f.getName());
            }
        }
        return result;
    }


    public static String createTableStatement(Class clazz) {
        String result = "CREATE TABLE IF NOT EXISTS ";
        String table = getTableNameEx(clazz);

        List<String> fields = getFieldsEx(clazz);
        if (table != null && fields != null) {
            result += table + " (pid INTEGER primary key AUTOINCREMENT,";
            int index = 0;
            for (String f : fields) {
                result += f + " TEXT";
                if (index < fields.size() - 1)
                    result += ",";
                index++;
            }
            result += ")";
            return result;
        }

        return null;
    }

    public static String createDropTableStatement(Class clazz) {
        String result = "DROP TABLE IF EXISTS ";
        String table = getTableNameEx(clazz);

        List<String> fields = getFieldsEx(clazz);
        if (table != null && fields != null) {
            result += table;

            return result;
        }

        return null;
    }

    public static String createSelectStatement(Class clazz) {
        String result = "SELECT #F FROM ";
        List<String> fields = getFieldsEx(clazz);
        String table = getTableNameEx(clazz);
        if (table != null) {
            String ff = "";
            int index=0;
            for (String f : fields) {
                ff += f;
                if (index < fields.size() - 1)
                    ff += ",";
                index++;
            }
            return result.replace("#F",ff) + table;
        }
        return null;
    }


    public static String createInsertStatement(Object object) {

        String result = "INSERT INTO ";

        String table = getTableName(object);
        if (table != null) {
            result += table + " (#F) VALUES (#V)";

            HashMap<String, String> values = getFields(object);
            if (values.size() > 0) {
                String fields = "";
                String value = "";
                int index = 0;
                for (Map.Entry<String, String> e : values.entrySet()) {
                    fields += e.getKey();
                    value += "'" + e.getValue() + "'";
                    if (index < values.size() - 1) {
                        fields += ",";
                        value += ",";
                    }
                    index++;
                }
                result = result.replace("#F", fields);
                result = result.replace("#V", value);

                return result;
            }
            return null;
        }

        return null;
    }
}
