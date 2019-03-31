package ru.otus;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
//        System.out.println(String.format("Out message %s number: %d", "STRING", 10));
//        System.err.println("Err message");
/*
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum = increment(sum, i);
            Thread.sleep(1000);
        }
*/
        System.out.println("Starting pid: " + ManagementFactory.getRuntimeMXBean().getName());
        SumServer server = new SumServer();
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("ru.otus:type=SumServer");
        mbs.registerMBean(server, name);
        server.run();
//        logExamples();
    }

    private static int increment(int sum, int i) {
        sum += i;
        System.out.println(String.format("sum(%d): %d", i, sum));
        return sum;
    }

    private static void logExamples() {
        System.out.println("Out hello!");
        System.err.println("Err hello!");

        logger.info("Main started");
        logger.log(Level.SEVERE, "File output error!");
    }
}
