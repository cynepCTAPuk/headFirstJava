package chap04_control;

public class Exercise9a {
    public static void main(String[] args) {
//        int n = 20;
        int n = Integer.parseInt(args[0]);
        fibonacci(n);
    }

    public static void fibonacci(int n) {
        int prev = 1;
        int curr = 1;
        int next;
        System.out.print("First " + n + " Fibonacci numbers\n" + prev + " " + curr + " ");
        for (int i = 2; i < n; i++) {
            next = prev + curr;
            System.out.print(next + " ");
            prev = curr;
            curr = next;
        }
    }
}
