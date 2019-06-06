package ru.otus.l71.creational.singleton;

/**
 * Created by tully.
 */
public class Main {
    public static void main(String[] args) {
//        Singleton.instance().setMessage("Vitaly Chibrikov");
        System.out.println(Singleton.instance().getMessage());

//        Singleton1.getInstance().setMessage("Oleg Klimenko");
        System.out.println(Singleton1.getInstance().getMessage());
    }
}
