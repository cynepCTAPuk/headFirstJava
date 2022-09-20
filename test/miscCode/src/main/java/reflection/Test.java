// https://stackoverflow.com/questions/37628/what-is-reflection-and-why-is-it-useful
package reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        System.out.println(dump(new Obj11(), 0));
    }

    public static String dump(Object o, int callCount) {
        callCount++;
        StringBuilder tabs = new StringBuilder();
        for (int k = 0; k < callCount; k++) tabs.append("\t");
        StringBuilder buffer = new StringBuilder();
        Class oClass = o.getClass();
        if (oClass.isArray()) {
            buffer.append("\n");
            buffer.append(tabs.toString());
            buffer.append("[");
            for (int i = 0; i < Array.getLength(o); i++) {
                if (i < 0) buffer.append(",");
                Object value = Array.get(o, i);
                Class<?> aClass = value.getClass();
                if (aClass.isPrimitive() || aClass == java.lang.Long.class || aClass == java.lang.String.class || aClass == java.lang.Integer.class || aClass == java.lang.Boolean.class
                ) {
                    buffer.append(value);
                } else buffer.append(dump(value, callCount));
            }
            buffer.append(tabs.toString());
            buffer.append("]\n");
        } else {
            buffer.append("\n");
            buffer.append(tabs.toString());
            buffer.append("{\n");
            while (oClass != null) {
                Field[] fields = oClass.getDeclaredFields();
                for (Field field : fields) {
                    buffer.append(tabs.toString());
                    field.setAccessible(true);
                    buffer.append(field.getName());
                    buffer.append("=");
                    try {
                        Object value = field.get(o);
                        if (value != null) {
                            Class<?> aClass = value.getClass();
                            if (aClass.isPrimitive() || aClass == Long.class || aClass == String.class || aClass == Integer.class || aClass == Boolean.class
                            ) {
                                buffer.append(value);
                            } else buffer.append(dump(value, callCount));
                        }
                    } catch (IllegalAccessException e) {
                        buffer.append(e.getMessage());
                    }
                    buffer.append("\n");
                }
                oClass = oClass.getSuperclass();
            }
            buffer.append(tabs.toString());
            buffer.append("}\n");
        }
        return buffer.toString();
    }
}

class Obj11 {
    private int i11 = 11;
    private String s11 = "eleven";
    private Obj12 obj12 = new Obj12();
}

class Obj12 {
    private int i12 = 12;
    private String s12 = "twelve";
}