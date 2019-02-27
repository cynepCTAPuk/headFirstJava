package puzzle_1;

public class Oddity {
    public static boolean isOdd(int i) {
        return i % 2 == 1;
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println("number " + number + " is odd?\n" +  isOdd(5));
    }
}
