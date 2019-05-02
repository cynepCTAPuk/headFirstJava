package chap7_adapter;

import chap7_adapter.turkeyAndDuck.MallardDuck;
import chap7_adapter.turkeyAndDuck.Turkey;
import chap7_adapter.turkeyAndDuck.WildTurkey;

public class TurkeyTestDrive {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        Turkey duckAdapter = new DuckAdapter(duck);

        System.out.println("The Duck says...");
        duck.quack();
        duck.fly();

        System.out.println("\nThe Turkey says...");
        testTurkey(turkey);


        System.out.println("\nThe TurkeyAdapter says...");
        testTurkey(duckAdapter);
    }

    static void testTurkey(Turkey turkey) {
        turkey.gobble();
        turkey.fly();
    }
}