package patterns.factory_method;

public class CatHouse extends AnimalHouse {
    @Override
    protected Animal createAnimal() {
        return new Cat();
    }
}
