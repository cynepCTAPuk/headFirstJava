package p030;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 1000-digit Fibonacci number
 * <p>
 * The Fibonacci sequence is defined by the recurrence relation:
 * <p>
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 * <p>
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 * <p>
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 *
 * 4782 - 1_000-digit Fibonacci number
 */
public class n025 {
    public static void main(String[] args) {
        List<BigInteger> list = new ArrayList<>();
        list.add(new BigInteger("1"));
        list.add(new BigInteger("1"));
        int n = 12;
        int i = 2;
        while (true) {
            BigInteger current = list.get(i - 2).add(list.get(i - 1));
            list.add(current);
            if (current.toString().length() == 1_000) {
                System.out.println(current.toString());
                System.out.println(i + 1);
                break;
            }
            i++;
        }
    }
}
