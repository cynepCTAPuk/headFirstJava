package chap05_Inheritance.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * This program uses reflection to print all features of a class.
 *
 * @author Cay Horstmann
 * @version 1.11 2018-03-16
 */
public class ReflectTest {
    public static void main(String[] args) {

//        String name = "java.lang.Class";    // 1 method
//        Class cl = Class.forName(name);     // 1 method

//        var clazz = new Random();         // 2 method
//        Class cl = clazz.getClass();      // 2 method

        Class cl = ArrayList.class;           // 3 method

//        Object obj = cl.getConstructor().newInstance();
        Class supercl = cl.getSuperclass();

        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0)
            System.out.print(modifiers + " ");

        System.out.print("class " + cl.getSimpleName());
        if (supercl != null && supercl != Object.class)
            System.out.print(" extends " + supercl.getName());

        System.out.print("\n{\n");
        printConstructors(cl);
        printMethods(cl);
        printFields(cl);
        printAnnotations(cl);
        printInnerClasses(cl);
        System.out.println("}");
    }

    /**
     * Prints all constructors of a class
     *
     * @param cl a class
     */
    public static void printConstructors(Class cl) {
        System.out.println("-".repeat(10) + "printConstructors");
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");

            // print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Prints all methods of a class
     *
     * @param cl a class
     */
    public static void printMethods(Class cl) {
        System.out.println("-".repeat(10) + "printMethods");
        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("   ");
            // print modifiers, return type and method name
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");

            // print parameter types
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Prints all fields of a class
     *
     * @param cl a class
     */
    public static void printFields(Class cl) {
        System.out.println("-".repeat(10) + "printFields");
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    public static void printAnnotations(Class cl) {
        System.out.println("-".repeat(10) + "printAnnotations");
        Annotation[] annotations = cl.getDeclaredAnnotations();
        for (Annotation a : annotations) {
            Class type = a.annotationType();
            System.out.print("   ");
            System.out.println(type + ";");
        }
    }

    public static void printInnerClasses(Class cl) {
        System.out.println("-".repeat(10) + "printInnerClasses");
        Class[] classes = cl.getDeclaredClasses();
        for (Class c : classes) {
            String name = c.getSimpleName();
            System.out.print("   ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(name + ";");
        }
    }
}
