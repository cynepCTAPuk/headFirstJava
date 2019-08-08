package chap28_Concurrency;
// An example that uses a Callable

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> f1;
        Future<Double> f2;
        Future<Integer> f3;
        System.out.println("Starting");

        f1 = es.submit(new Sum(10));
        f2 = es.submit(new Hypotenuse(3, 4));
        f3 = es.submit(new Factorial(5));

        try {
            System.out.println("Sum of first 10 numbers: " + f1.get());
            System.out.println("Triangle hypotenuse with sides 3 and 4: " + f2.get());
            System.out.println("Factorial! 5: " + f3.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
        es.shutdown();
        System.out.println("Done");
    }
}

class Sum implements Callable<Integer> {
    private int stop;

    Sum(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 1; i <= stop; i++) sum += i;
        return sum;
    }
}

class Hypotenuse implements Callable<Double> {
    private double side1, side2;

    Hypotenuse(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public Double call() {
        return Math.sqrt(side1 * side1 + side2 * side2);
    }
}

class Factorial implements Callable<Integer> {
    private int stop;

    Factorial(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() {
        int factorial = 1;
        for (int i = 2; i <= stop; i++) factorial *= i;
        return factorial;
    }
}