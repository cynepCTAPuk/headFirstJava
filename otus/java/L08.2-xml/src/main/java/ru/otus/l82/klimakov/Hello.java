package ru.otus.l82.klimakov;

import java.lang.reflect.Constructor;

public class Hello extends Object{
    public static final Class clazz = Hello.class;

    public void hello() {
        Class type = this.getClass();
        Class cs = String.class;
        try {
            Constructor constructor = cs.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(clazz);
    }
}
