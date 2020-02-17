package shortPuzzles;

/**
 * https://habr.com/ru/post/278867/
 */
public class FizzBuzz2 {
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            String n = "" + i, f = "Fizz", b = "Buzz";
            if (i % 3 != 0) f = "";
            else n = "";
            if (i % 5 != 0) b = "";
            else n = "";
            System.out.println(n + f + b);
        }
    }
}
