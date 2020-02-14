package concurrency;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StackWindowTest {
    public static void main(final String args[]) throws Exception {
        Thread.UncaughtExceptionHandler handler =
                new StackWindow("Show Exception Stack", 400, 200);
        Thread.setDefaultUncaughtExceptionHandler(handler);
        new Thread() {
            public void run() {
                System.out.println(1 / 0);
            }
        }.start();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Press Enter for next exception");
        bufferedReader.readLine();
        new Thread() {
            public void run() {
                System.out.println(args[0]);
            }
        }.start();
        System.out.print("Press Enter to end");
        bufferedReader.readLine();
        System.exit(0);
    }
}