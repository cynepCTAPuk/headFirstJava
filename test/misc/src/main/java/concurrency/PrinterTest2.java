package concurrency;

public class PrinterTest2 {
    public static void main(String[] args) {
        Printer2 printer1 = new Printer2("Вася");
        printer1.start();
        Printer2 printer2 = new Printer2("Коля");
        printer2.start();
    }
}

class Printer2 extends Thread {
    private String name;

    public Printer2(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("I’m " + this.name);
    }
}