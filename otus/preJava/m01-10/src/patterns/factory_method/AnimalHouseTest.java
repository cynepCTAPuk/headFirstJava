package patterns.factory_method;

public class AnimalHouseTest {
    public static void main(String[] args) {
        CatHouse catHouse = new CatHouse();
        DogHouse dogHouse = new DogHouse();

        System.out.println(catHouse);
        System.out.println(dogHouse);
    }
}
