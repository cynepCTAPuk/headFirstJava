package concurrency.other;

public class PrinterTest1 {
    public static void main(String[] args) {
        Printer1 printer1 = new Printer1("Коля");
        Thread thread1 = new Thread(printer1);
        thread1.start();
        Printer1 printer2 = new Printer1("Вася");
        Thread thread2 = new Thread(printer2);
        thread2.start();
        Printer1 printer3 = new Printer1("Наташа");
        Thread thread3 = new Thread(printer3);
        thread3.start();
        Thread thread4 = new Thread(printer3);
        thread4.start();
        Thread thread5 = new Thread(printer3);
        thread5.start();

    }
}

class Printer1 implements Runnable {
    private String name;

    public Printer1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("I'm "+ this.name);
    }
}