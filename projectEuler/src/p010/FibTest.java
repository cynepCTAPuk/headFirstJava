package p010;

import java.math.BigInteger;
import java.util.stream.Collectors;

public class FibTest {
    public static BigInteger seqSum(int n) {
        BigInteger first = BigInteger.ZERO;
        BigInteger second = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            BigInteger s = second.add(first);
            first = second;
            second = s;
            sum = sum.add(first);
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.printf("%-10s = %20s%n", "generate",FibGenerate.stream()
                .parallel().limit(n).reduce(BigInteger::add).orElse(BigInteger.ZERO));
        System.out.printf("%-10s = %20s%n", "iterate",FibIterate.stream()
                .parallel().limit(n).reduce(BigInteger::add).orElse(BigInteger.ZERO));
        System.out.printf("%-10s = %20s%n", "iterator",FibIterator.stream()
                .parallel().limit(n).reduce(BigInteger::add).orElse(BigInteger.ZERO));
        System.out.printf("%-10s = %20s%n", "oldSchool",seqSum(n));
    }
}
