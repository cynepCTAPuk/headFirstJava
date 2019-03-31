package patterns.factory_method;

public abstract class AnimalHouse {
    private final Animal animal;

    AnimalHouse() {
        //build a house
        //add a bowl
        //add toys

        //create an animal
        animal = createAnimal();
        animal.makeSound();
    }

    protected abstract Animal createAnimal();

    public Animal getAnimal() {
        return animal;
    }
}
