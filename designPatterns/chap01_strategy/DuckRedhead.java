package chap01_strategy;

public class DuckRedhead extends Duck {
    public DuckRedhead() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    public void display() {
        System.out.println("-I'm a Readhead duck-");
    }
}
