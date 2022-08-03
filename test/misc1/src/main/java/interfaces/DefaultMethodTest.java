package interfaces;

public class DefaultMethodTest {
    interface Human {
        default void walk() {
            System.out.println("I go away!");
        }
    }
    interface Animal{
        static void run() {
            System.out.println("I run");
        }
    }

    public static void main(String[] args) {
        Human human = new Human() {};
        human.walk();
        Animal.run();
    }
}
