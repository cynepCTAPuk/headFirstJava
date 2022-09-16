package generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Zoo<T> {
    Class<T> clazz;
    ArrayList<T> animals = new ArrayList<>();

    public Zoo(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T createNewAnimal() {
//        T animal = clazz.newInstance();
        T animal = null;
        try {
            animal = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException
                | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        animals.add(animal);
        return animal;
    }

    public static void main(String[] args) {
        Zoo<Tiger> zoo = new Zoo<>(Tiger.class);
        Tiger tiger = zoo.createNewAnimal();
        System.out.println(tiger);
    }

    private static class Tiger {
        public Tiger() {
        }
    }
}
