package concurrency.other;

import java.util.concurrent.Executor;

public class ExecutorTest implements Executor {
    @Override
    public void execute(Runnable command) {

    }

    public static void main(String[] args) {
        int[] array = new int[3];
        System.out.println(array.length);
    }
}
