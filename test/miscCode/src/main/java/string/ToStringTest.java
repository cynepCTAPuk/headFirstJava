package string;

public class ToStringTest {
    public static void main(String[] args) {
        Cat cat = new Cat("Vaska");
        String text = "Mya cat is " + cat;
        System.out.println(text);

        text = 5 + '\u0000' + "Log";
        System.out.println(text);

        System.out.println((int) ' ');

        text = "Object is " + (float) 2 / 3;
        System.out.println(text);
    }
}

class Cat {
    String name;

    public Cat(String name) {
        this.name = name;
    }
}
