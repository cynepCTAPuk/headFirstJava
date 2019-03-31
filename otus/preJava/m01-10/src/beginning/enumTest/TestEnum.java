package beginning.enumTest;

public class TestEnum {
    public static void main(String[] args) {
        for (Seasons s : Seasons.values()) System.out.println(s);

        Seasons arg = Seasons.Autumn;
        switch (arg) {
            case Winter:
                System.out.println("It's winter! Christmas time!");
                break;
            case Summer:
                System.out.println("It's summer! Let's go to the beach!");
                break;
            case Spring:
                System.out.println("It's spring! Easter is coming!");
                break;
            case Autumn:
                System.out.println("It's fall! Helloween is coming!");
                break;
        }
    }
}

