package concurrency.other;

public class ThreadPriority {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                setPriority(0);
                System.out.println("Example");
            }

        }.start();
        System.out.println("Example1");
    }
}
