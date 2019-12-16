package concurrency;

public class MyThread {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            MyFirstThread thread = new MyFirstThread();
            thread.start();
        }
    }
}

class MyFirstThread extends Thread {

    @Override
    public void run() {
        System.out.println("I'm Thread! My name is " + getName());
    }
}