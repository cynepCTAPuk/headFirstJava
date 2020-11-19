package aaa;

public class SwitchTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(digit((int) (Math.random() * 9)));
        }
    }

    private static String digit(int a) {
        String x = "";
        switch (a) {
            case 0:
                x = "Ноль";
                break;
            case 1:
                x = "Один";
                break;
            case 2:
                x = "Два";
                break;
            case 3:
                x = "Три";
                break;
            case 4:
                x = "Четыре";
                break;
            case 5:
                x = "Пять";
                break;
            case 6:
                x = "Шесть";
                break;
            case 7:
                x = "Семь";
                break;
            case 8:
                x = "Восемь";
                break;
            case 9:
                x = "Девять";
                break;
        }
        return x;
    }
}
