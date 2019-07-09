public class Thread13 {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello, World!");
        }
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
    }
}
