package chap01_strategy;

public class DuckModel extends Duck {
    public DuckModel() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }
    public void display() {
        System.out.println("-I'm a model duck-");
    }
}