import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
    public static final int prime = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String text = scanner.nextLine();

        int p = pattern.length();
        int t = text.length();

        long hashPattern = hash(pattern);
        long hash = hash(text.substring(t - p));
        LinkedList<Integer> list = new LinkedList<>();
        long x = BigInteger
                         .valueOf(263)
                         .modPow(BigInteger.valueOf(p - 1), BigInteger.valueOf(prime))
                         .longValue();
        for (int i = t - p; i >= 0; i--) {
            if (i < t - p) {
                hash = ((hash + prime - ((text.charAt(i + p) * x) % prime)) * 263 + text.charAt(i))
                               % prime;
            }
            if (hash == hashPattern && text.substring(i, i + p).equals(pattern)) {
                list.addFirst(i);
            }
        }
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    private static long hash(String string) {
        long hash = 0L;
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            long x = BigInteger
                             .valueOf(263)
                             .modPow(BigInteger.valueOf(i), BigInteger.valueOf(prime))
                             .longValue();
            hash += charArray[i] * x;
        }
        hash %= prime;
        return hash;
    }
}
