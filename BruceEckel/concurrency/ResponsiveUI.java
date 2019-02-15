//: concurrency/ResponsiveUI.java
// User interface responsiveness.
// {RunByHand}
package concurrency;

class UnresponsiveUI {
    private volatile double result = 1;
    public UnresponsiveUI() throws Exception {
        while (result > 0) result = result + (Math.PI + Math.E) / result;
        System.in.read(); // Never gets here
    }
}

public class ResponsiveUI extends Thread {
    private static volatile double result = 1;
    public ResponsiveUI() {
        setDaemon(true);
        start();
    }
    public void run() {
        while (true) result = result + (Math.PI + Math.E) / result;
    }

    public static void main(String[] args) throws Exception {
//        new UnresponsiveUI(); // Must kill this process
        new ResponsiveUI();
        System.in.read();
        System.out.printf("%,f", result); // Shows progress
    }
} ///:~