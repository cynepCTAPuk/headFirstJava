package book.chap16;

class TestGenerics1 {
    public static void main(String[] args) {
        new TestGenerics2().go();
    }

    public void go() {
        Animal[] animals = {new Dog(), new Cat(), new Dog()};
        Dog[] dogs = {new Dog(), new Dog(), new Dog()};
        takeAnimals(animals);
        takeAnimals(dogs);
    }

    public void takeAnimals(Animal[] animals) {
        for (Animal a : animals) {
            a.eat();
        }
    }
}

abstract class Animal {
    void eat() {
        System.out.println("animal eating");
    }
}

class Dog extends Animal {
    void bark() {
    }

    @Override
    void eat() {
        System.out.println("dog eating");
    }
}

class Cat extends Animal {
    void meow() {
    }

    @Override
    void eat() {
        System.out.println("cat eating");
    }
}
