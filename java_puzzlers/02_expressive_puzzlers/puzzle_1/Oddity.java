package puzzle_1;

public class Oddity {
    public static boolean isOdd(int i) {
//        return (i < 0 ? -i : i) % 2 == 1;
//        return i % 2 != 0;
        return (i & 1) != 0;
    }

    public static void main(String[] args) {
        int number = -5;
        System.out.println("number " + number + " is odd?\n" + isOdd(number));
    }
}
