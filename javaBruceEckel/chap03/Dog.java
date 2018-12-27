package chap03;

public class Dog {
    String name;
    String says;

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        dog1.name = "Spot";
        dog2.name = "Scruffy";
        dog1.says = "Ruff!";
        dog2.says = "Wurf!";

        System.out.println(dog1.name + " says: " + dog1.says);
        System.out.println(dog2.name + " says: " + dog2.says);

        Dog dog3;
        dog3 = dog1;
        System.out.println(dog3.name + " says: " + dog3.says);

    }
}
