package reflection.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    @SuppressWarnings("unused")
    public static Class getExpectedClass() {
        Class[] clazzes = Collections.class.getDeclaredClasses();
        for (Class clazz : clazzes) {
            boolean isPrivate = Modifier.isPrivate(clazz.getModifiers());
            boolean isStatic = Modifier.isStatic(clazz.getModifiers());
            if (isPrivate && isStatic &&
                    (Arrays.toString(clazz.getInterfaces()).contains("List") ||
                            Arrays.toString(clazz.getSuperclass().getInterfaces()).contains("List"))) {
                try {
                    Method method = clazz.getDeclaredMethod("get", int.class);
                    Constructor constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    method.setAccessible(true);
                    method.invoke(constructor.newInstance(), 1);
                } catch (InvocationTargetException e) {
                    System.out.println(Arrays.toString(e.getStackTrace()));
//                    System.out.println(e.getTargetException());
                    if(e.getCause().toString().contains("IndexOutOfBoundsException"))
                        return clazz;
                } catch (IllegalAccessException e) {
//                    System.out.println(e);
                } catch (NoSuchMethodException e) {
//                    System.out.println(e);
                } catch (InstantiationException e) {
//                    System.out.println(e);
                }
            }
        }
        return null;
    }
}
