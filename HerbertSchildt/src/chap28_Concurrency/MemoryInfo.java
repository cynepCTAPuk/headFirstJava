package chap28_Concurrency;

import java.io.File;

public class MemoryInfo {
    public static void main(String[] args) {
        /* Total number of processors or cores available to the JVM */
        System.out.println(
                "Available processors (cores): " + Runtime.getRuntime().availableProcessors());

        /* Total amount of free memory available to the JVM */
        System.out.printf(
                "Free memory (bytes): %,d\n", Runtime.getRuntime().freeMemory());

        /* This will return Long.MAX_VALUE if there is no preset limit */
        long maxMemory = Runtime.getRuntime().maxMemory();
        /* Maximum amount of memory the JVM will attempt to use */
        System.out.printf(
                "Maximum memory (bytes): %,d\n", (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

        /* Total memory currently available to the JVM */
        System.out.printf(
                "Total memory available to JVM (bytes): %,d\n", Runtime.getRuntime().totalMemory());

        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();

        /* For each filesystem root, print some info */
        double kilo = 1_024.0;
        for (File root : roots) {
            System.out.println("File system root: " + root.getAbsolutePath());
            System.out.printf("Total  space (Gigabytes): %,10.3f\n", root.getTotalSpace() / kilo / kilo / kilo);
            System.out.printf("Free   space (Gigabytes): %,10.3f\n", root.getFreeSpace() / kilo / kilo / kilo);
//            System.out.printf("Usable space (Gigabytes): %,10.3f\n", root.getUsableSpace()/kilo/kilo/kilo);
        }
    }
}