package chap15_Lambda;

interface NumbericTest {
    boolean test(int n);
}

public class LambdaDemo2 {
    public static void main(String[] args) {
        NumbericTest isEven = (n) -> (n % 2) == 0;
        if (isEven.test(10)) System.out.println("Number 10 is even");
        if (!isEven.test(9)) System.out.println("Number 9 is odd");

        NumbericTest isNonNeg = n -> n >= 0;
        if (isNonNeg.test(1)) System.out.println("Number 1 is non negative");
        if (!isNonNeg.test(-1)) System.out.println("Number -1 is negative");
    }
}
