package concurrency;

public class PrinterTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread childThread = new Thread(printer);
        childThread.start();
        System.out.println("Printer started");
        System.out.println("Main thread finished");
    }
}

class Printer implements Runnable {

    @Override
    public void run() {
        System.out.println("I'm printer");
        System.out.println("Printer thread finished");
    }
}