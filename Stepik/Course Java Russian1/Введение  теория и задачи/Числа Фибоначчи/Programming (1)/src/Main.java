import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % 10;
            a = b;
            b = c;
        }
        if (n == 1) c = b;
        System.out.println(c);
    }
}