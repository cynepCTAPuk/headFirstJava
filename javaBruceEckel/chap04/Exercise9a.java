package chap04;

public class Exercise9a {
    public static void main(String[] args) {
        int n = 20;
        
        fibonacci(n);
    }

    public static void fibonacci(int n) {
        int prev = 1;
        int curr = 1;
        int next;
        System.out.print(prev + " " + curr + " ");
        for (int i = 2; i < n; i++) {
            next = prev + curr;
            System.out.print(next);
            System.out.print(" ");
            prev = curr;
            curr = next;
        }
    }
}
