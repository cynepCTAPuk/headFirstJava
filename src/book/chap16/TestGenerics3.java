
package book.chap16;

import java.util.ArrayList;
import java.util.Iterator;

class TestGenerics3 {
    public static void main(String[] args) {
        new TestGenerics3().go();
    }

    public void go() {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());
        takeAnimals(animals);
        System.out.println();
        for (Iterator it = animals.iterator(); it.hasNext(); ) System.out.println(it.next());
        System.out.println();

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        takeAnimals(dogs);
    }

    public void takeAnimals(ArrayList<? extends Animal> animals) {
        for (Animal a : animals) {
            a.eat();
        }
    }
}