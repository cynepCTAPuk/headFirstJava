package web.stepik.web2;

public class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new HelloThread();
        thread.start();
        thread.join();
        System.out.println("Hello from the main");
    }
}
