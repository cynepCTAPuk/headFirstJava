package ru.otus.task3;

public class Main_class {
    private static final String hello = "Hello";

    public static void main(String[] args) {
        String a = hello;
        String b = Main_class.hello;
        java.lang.Class<Main_class> m = Main_class.class;
        Main_class n = new Main_class();

        System.out.println(java.util.Arrays.toString(m.getAnnotations()));
        System.out.println(java.util.Arrays.toString(m.getClasses()));
        System.out.println(java.util.Arrays.toString(m.getConstructors()));
        System.out.println(java.util.Arrays.toString(m.getEnumConstants()));
        System.out.println(java.util.Arrays.toString(m.getFields()));

        System.out.println(java.util.Arrays.toString(m.getMethods()));

        System.out.println(m.getPackage());
        System.out.println(m.getPackageName());
    }
}
