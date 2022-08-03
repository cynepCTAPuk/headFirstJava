package aaa;

public class SwitchTest {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            double d = Math.random()*9;
            System.out.print(digit((int) d));
            System.out.print(" ");
            System.out.println(dayOfWeek((int) d));
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

    private static String dayOfWeek(int a) {
        String x = "";
        switch (a) {
            case 0:
                x = "Воскресенье";
                break;
            case 1:
                x = "Понедельник";
                break;
            case 2:
                x = "Вторник";
                break;
            case 3:
                x = "Среда";
                break;
            case 4:
                x = "Четверг";
                break;
            case 5:
                x = "Пятница";
                break;
            case 6:
                x = "Суббота";
                break;
            default:
                x = "Oops";
        }
        return x;
    }
}
