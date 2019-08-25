package chap05_Inheritance.objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * Converts an object to a string representation that lists all fields.
     *
     * @param obj an object
     * @return a string with the object's class name and all field names and values
     */
    public String toString(Object obj) throws ReflectiveOperationException {
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);

        Class cl = obj.getClass();
        if (cl == String.class) return (String) obj;

        if (cl.isArray()) {
            String result = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) result += ",";
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) result += val;
                else result += toString(val);
            }
            return result + "}";
        }

        String result = cl.getName();
        // inspect the fields of this class and all superclasses
        do {
            result += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            // get the names and values of all fields
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!result.endsWith("[")) result += ",";
                    result += f.getName() + "=";
                    Class t = f.getType();
                    Object val = f.get(obj);
                    if (t.isPrimitive()) result += val;
                    else result += toString(val);
                }
            }
            result += "]";
            cl = cl.getSuperclass();
        } while (cl != null);

        return result;
    }
}
