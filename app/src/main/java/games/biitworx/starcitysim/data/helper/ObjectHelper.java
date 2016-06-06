package games.biitworx.starcitysim.data.helper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import games.biitworx.starcitysim.data.DbField;
import games.biitworx.starcitysim.data.DbReference;
import games.biitworx.starcitysim.data.DbTable;

/**
 * Created by marcel.weissgerber on 25.05.2016.
 */
public class ObjectHelper {




    public static String getTableNameEx(Class clazz) {
        DbTable o = (DbTable) clazz.getAnnotation(DbTable.class);
        if (o != null)
            return clazz.getSimpleName();
        return null;
    }


    public static HashMap<String, String> getFields(Object object) {
        Field[] fields = getDeclaredFields(object.getClass());
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


    public static HashMap<String,DbReference> getReferencesEx(Class clazz) {
        Field[] fields = getDeclaredFields(clazz);
        HashMap<String,DbReference> result = new HashMap<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(DbReference.class)) {
                result.put(f.getName(),f.getAnnotation(DbReference.class));
            }
        }
        return result;
    }

    public static List<String> getFieldsEx(Class clazz) {
        Field[] fields = getDeclaredFields(clazz);
        List<String> result = new ArrayList<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(DbField.class)) {
                f.setAccessible(true);
                result.add(f.getName());
            }
        }
        return result;
    }

    public static Field getDeclaredFieldByName(Class clazz,String name){
        Field[] fields = getDeclaredFields(clazz);
        for(Field f:fields){
            if(f.getName().equals(name))
                return f;
        }
        return null;
    }

    private static Field[] getDeclaredFields(Class clazz) {
        Field[] result = clazz.getDeclaredFields();
        if(clazz.getSuperclass()!=Object.class){
            Field[] resultSuperclass = getDeclaredFields(clazz.getSuperclass());
            if(resultSuperclass.length>0){
                Field[] resultCombined =new Field[result.length+resultSuperclass.length];
                int index=0;
                for(Field f :result) {
                    resultCombined[index] = f;
                    index++;
                }

                for(Field f :resultSuperclass) {
                    resultCombined[index] = f;
                    index++;
                }
                result=resultCombined;
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


    public static List<String> createReferenceTableStatement(Class clazz) {

        HashMap<String,DbReference> ref = getReferencesEx(clazz);
        List<String> refs=new ArrayList<>();
        if(ref!=null){
            for(Map.Entry<String,DbReference> e : ref.entrySet()){

                String result = "CREATE TABLE IF NOT EXISTS ";
                String table = e.getKey()+" (parent TEXT,child TEXT)";
                refs.add(result+table);
            }
        }


        return refs;
    }

    public static List<String> createDropReferenceTableStatement(Class clazz) {

        HashMap<String,DbReference> ref = getReferencesEx(clazz);
        List<String> refs=new ArrayList<>();
        if(ref!=null){
            for(Map.Entry<String,DbReference> e : ref.entrySet()){

                String result = "DROP TABLE IF EXISTS ";
                String table = e.getKey();
                refs.add(result+table);
            }
        }


        return refs;
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



    public static String createInsertStatement(Object object) {

        String result = "INSERT INTO ";

        String table = getTableNameEx(object.getClass());
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

    public static String createUpdateStatement(Object object,int pid) {

        String result = "UPDATE ";

        String table = getTableNameEx(object.getClass());
        if (table != null) {
            result += table + " SET ";

            HashMap<String, String> values = getFields(object);
            if (values.size() > 0) {
                String fields = "";

                int index = 0;
                for (Map.Entry<String, String> e : values.entrySet()) {
                    fields += e.getKey();
                    fields += "='" + e.getValue() + "'";
                    if (index < values.size() - 1) {
                        fields += ",";

                    }
                    index++;
                }
                result+=fields+" WHERE pid="+pid;

                return result;
            }
            return null;
        }

        return null;
    }
}
