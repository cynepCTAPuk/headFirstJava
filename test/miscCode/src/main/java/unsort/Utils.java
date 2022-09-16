package aaa;

public class Utils {
    public static void main(String[] args) {
        for (int i = -5; i < 5; i++) {
            System.out.println(i + ":" + (oddOrNot(i) ? "odd" : "even"));
        }
    }

    public static boolean oddOrNot(int num) {
        return (num & 1) != 0;
    }
}
