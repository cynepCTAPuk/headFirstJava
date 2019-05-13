package chap01_strategy;

public class DuckRubber extends Duck {
    public DuckRubber() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new QuackSqueak();
    }
    public void display() {
        System.out.println("-I'm a Rubber duck-");
    }
}