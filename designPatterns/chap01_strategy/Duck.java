package chap01_strategy;
/*
Паттерн Стратегия определяет семейство алгоритмов,
  инкапсулирует каждый из них и обеспечивает их взаимозаменяемость.
  Он позволяет модифицировать алгоритмы независимо
  от их использования на стороне клиента.
1 Выделите аспекты приложения, которые могут изменяться,
  и отделите их от тех, которые всегда остаются постоянными
2 Программируйте на уровне интерфейса, а не на уровне реализации
3 Отдавайте предпочтение композиции перед наследнованием
 */

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    public Duck() {}

    public abstract void display();
    public void swim() { System.out.println("All ducks float, even decoys!");}

    public void performFly() { flyBehavior.fly();}
    public void setFlyBehavior(FlyBehavior fb) { flyBehavior = fb;}

    public void performQuack() { quackBehavior.quack();}
    public void setQuackBehavior(QuackBehavior qb) { quackBehavior = qb;}
}


