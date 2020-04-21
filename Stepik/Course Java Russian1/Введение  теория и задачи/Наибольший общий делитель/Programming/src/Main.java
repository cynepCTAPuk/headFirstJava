import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long b = scanner.nextInt();
        System.out.println(gcd(a, b));
    }

    public static long gcd(long a, long b) {
        while (a != 0 && b != 0) {
            if (a > b) a = a % b;
            else b = b % a;
        }
        return a + b;
    }
}