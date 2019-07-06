package ru.otus.jmm;

public class FactoryTest {

    public static void main(String[] args) {
        System.out.println(Factory.instance);
        System.out.println(Factory.get());
        System.out.println(Factory.instance);
    }
}
