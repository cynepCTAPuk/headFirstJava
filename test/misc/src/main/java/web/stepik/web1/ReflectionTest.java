package web.stepik.web1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * https://stepik.org/lesson/12497/step/2?unit=2967
 * 2.3 "Углубленные" основы языка
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException {
        String s = "";
        List<Integer> list = new ArrayList<>();
//        Class clazz = list.getClass();
        Class clazz = Class.forName("ArrayList");

        Annotation[] annotations = clazz.getAnnotations();
        Field[] fields = clazz.getFields();
        Class[] classes = clazz.getClasses();
        Class[] interfaces = clazz.getInterfaces();
        Constructor[] constructors = clazz.getConstructors();
        Method[] methods = clazz.getMethods();
        Object[] signers = clazz.getSigners();

//        for (Annotation annotation : annotations) System.out.println(annotation);
//        for (Field field : fields) System.out.println(field);
//        for (Class classs : classes) System.out.println(classs);
        for (Class interfacce : interfaces) System.out.println(interfacce);
//        for (Constructor constructor : constructors) System.out.println(constructor);
//        for (Method method : methods) System.out.println(method);
//        for (Object sign : signers) System.out.println(sign);
    }
}

