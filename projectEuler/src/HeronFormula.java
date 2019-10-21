/**
 * https://ru.wikipedia.org/wiki/Итерационная_формула_Герона
 * https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Babylonian_method
 * https://en.wikipedia.org/wiki/Methods_of_computing_square_roots
 */
public class HeronFormula {
    public static void main(String[] args) {
        double n = 2;
        System.out.println(squareRoot(n));
    }

    public static double squareRoot(double number) {
        if (number <= 0) return -1;
        double squareRoot, temp;
        squareRoot = number / 2;
        int step = 0;
        do {
            temp = squareRoot;
            squareRoot = (temp + (number / temp)) / 2;
//            System.out.println(++step + ": " + squareRoot);
        }
        while ((temp - squareRoot) != 0);
        return squareRoot;
    }
}
