package chap01_strategy;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.display();
        model.performQuack();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

        Duck justDuck = new Duck() {
            @Override
            public void display() {
                System.out.println("-I'm justDuck!-");
            }
        };
        justDuck.display();
        justDuck.swim();
        justDuck.setFlyBehavior(new FlyNoWay());
        justDuck.performFly();
        justDuck.setQuackBehavior(new MuteQuack());
        justDuck.performQuack();
    }
}