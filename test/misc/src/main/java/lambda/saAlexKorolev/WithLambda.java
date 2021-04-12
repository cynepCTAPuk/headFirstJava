package lambda.saAlexKorolev;

import java.util.ArrayList;
import java.util.List;

public class WithLambda {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));
        animals.add(new Animal(null, false, true));
        print(animals, a -> a.canHop());
        print(animals, a -> a.canSwim());
        print(animals, a -> true);
        print(animals, new CheckTrait() {
            @Override
            public boolean test(Animal animal) {
                return animal.hasName();
            }
        });
    }

    private static void print(List<Animal> animals, CheckTrait checkTrait) {
                for (Animal animal : animals)
            if (checkTrait.test(animal))
                System.out.print(animal + " ");
        System.out.println();
    }
}
