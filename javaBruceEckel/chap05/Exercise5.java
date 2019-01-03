package chap05;

public class Exercise5 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.bark('a');
    }

}

class Dog {

    Dog() {
        System.out.println("new Dog");
    }

    void bark() {
        System.out.println("bark");
    }

    void bark(char ch) {
        System.out.println("howling");
    }
}