package chap01_strategy;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        System.out.println("MallardDuck");
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performQuack();
        mallard.performFly();

        System.out.println("\nModelDuck");
        Duck model = new ModelDuck();
        model.display();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

        System.out.println("\nJustDuck");
        Duck justDuck = new Duck() {
            @Override
            public void display() {
                System.out.println("I'm just justDuck!");
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