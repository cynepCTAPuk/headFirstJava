package shortPuzzles;

public class FizzBuzz1 {
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            String s = "";
            if (i % 3 == 0) s = "Fizz";
            if (i % 5 == 0) s += "Buzz";
            if (s.equals("")) s += i;
            System.out.println(s);
        }
    }
}
