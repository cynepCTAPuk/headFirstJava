package ru.otus;

import java.lang.management.ManagementFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/* remote connection to VM
-Dcom.sun.management.jmxremote.port=15025
-Dcom.sun.management.jmxremote.authenticate=false
-Dcom.sun.management.jmxremote.ssl=false
 */
public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting pid: " + ManagementFactory.getRuntimeMXBean().getName());
//        logExample();
        Server server = new Server("Current time: ")
        Object[] objects = new Object[1_000_000];
        while (true) {
            System.out.println(server.getMessage() + System.currentTimeMillis());
            Thread.sleep(100);
            for (int i = 0; i < objects.length; i++) {
                objects[i] = new Object();
            }
        }
    }

    private static void logExample() {
        System.out.println("Hello");
        System.err.println("Error");

        log.info("Info message");
        log.log(Level.INFO, "Info message");
        log.log(Level.SEVERE, "ERROR");
    }
}
