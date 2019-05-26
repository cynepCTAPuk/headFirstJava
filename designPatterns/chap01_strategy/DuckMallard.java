package chap01_strategy;

public class DuckMallard extends Duck {
    public DuckMallard() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("-I'm a real Mallard duck-");
    }
}
