package oop;

public class InstanceOf {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat instanceof Animal);
        System.out.println(cat instanceof MaineCoon);

        cat = new MaineCoon();
        System.out.println(cat instanceof Cat);
        System.out.println(cat instanceof MaineCoon);
    }
}

class Animal {}
class Cat extends Animal {}
class MaineCoon extends Cat {}

