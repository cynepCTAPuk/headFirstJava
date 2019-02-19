package chap21_concurrency;

class Fibonacci1 implements Runnable {
    private int f;
    public Fibonacci1(int f) { this.f = f;}
    private int ff = 0;
    public Integer next() { return fib(ff++);}
    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }
    @Override
    public void run() {
        for (int i = 0; i <= f; i++) System.out.printf("%,d ", next());
        System.out.println();
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        System.out.println("***** Beginning *****");
        new Thread(new Fibonacci1(20)).start();
        new Thread(new Fibonacci1(15)).start();
        new Thread(new Fibonacci1(10)).start();
        new Thread(new Fibonacci1(5)).start();
        System.out.println("***** Ending *****");

    }
}
