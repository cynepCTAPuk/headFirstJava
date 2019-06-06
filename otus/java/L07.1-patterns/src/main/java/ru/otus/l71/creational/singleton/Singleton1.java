package ru.otus.l71.creational.singleton;

/**
Oleg Klimenko
 */
public class Singleton1 {
    private static Singleton1 singleton = new Singleton1();
    private String message = "Oleg Klimenko";

    private Singleton1() {}

    public static Singleton1 getInstance(){
        return singleton;
    }

    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
}
