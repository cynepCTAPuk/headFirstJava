package chap28_Concurrency;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;

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
        System.out.println(
                "Maximum memory (bytes): " + (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

        /* Total memory currently available to the JVM */
        System.out.printf(
                "Total memory available to JVM (bytes): %,d\n", Runtime.getRuntime().totalMemory());

        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();

        /* For each filesystem root, print some info */
        double k = 1_024.0;
        for (File root : roots) {
            System.out.println("File system root: " + root.getAbsolutePath());
            System.out.printf(
                    "Total  space (Gigabytes): %,10.3f\n", root.getTotalSpace() / k / k / k);
            System.out.printf("Free   space (Gigabytes): %,10.3f\n", root.getFreeSpace() / k / k / k);
//            System.out.printf("Usable space (Gigabytes): %,10.3f\n", root.getUsableSpace()/k/k/k);
        }

        System.out.println("PROCESSOR_IDENTIFIER: " + System.getenv("PROCESSOR_IDENTIFIER"));
        System.out.println(
                "PROCESSOR_ARCHITECTURE: " + System.getenv("PROCESSOR_ARCHITECTURE"));
//        System.out.println(System.getenv("PROCESSOR_ARCHITEW6432"));
        System.out.println("NUMBER_OF_PROCESSORS: " + System.getenv("NUMBER_OF_PROCESSORS"));

        com.sun.management.OperatingSystemMXBean os =
                (com.sun.management.OperatingSystemMXBean)
                        ManagementFactory.getOperatingSystemMXBean();
        System.out.printf("TotalPhysicalMemorySize:    %,14d\n", os.getTotalPhysicalMemorySize());
        System.out.printf("FreePhysicalMemorySize:     %,14d\n", os.getFreePhysicalMemorySize());
        System.out.printf("FreeSwapSpaceSize:          %,14d\n", os.getFreeSwapSpaceSize());
        System.out.printf("CommittedVirtualMemorySize: %,14d\n", os.getCommittedVirtualMemorySize());
    }
}