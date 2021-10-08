package aaa;

public class Q210625_1 extends Thread {
    public void run() {
        System.out.println("Running");
    }
/*
    public void start() {
        System.out.println("Starting");
    }
*/

    public static void main(String[] args) {
        Q210625_1 q210625_1 = new Q210625_1();
        q210625_1.start();
    }
}

