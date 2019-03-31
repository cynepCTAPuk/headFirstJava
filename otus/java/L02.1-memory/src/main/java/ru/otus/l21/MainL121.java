package ru.otus.l21;

import java.lang.management.ManagementFactory;

/**
 * VM options
 * -Xmx512m -Xms512m
 * -XX:+UseCompressedOops //on
 * -XX:-UseCompressedOops //off
 * <p>
 * System.gc()
 * Runtime runtime = Runtime.getRuntime();
 * long mem = runtime.totalMemory() - runtime.freeMemory();
 * <p>
 * jconsole, connect to pid
 */
@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement", "UnusedAssignment"})
public class MainL121 {
  public static void main(String... args) throws InterruptedException {
    System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());
    int size = 20_000_000;
    System.out.println("Starting the loop");
    while (true) {
      long mem1 = getMem(); // Collect memory information
      System.out.println("Mem1: " + mem1);
      Object[] array = new Object[size];

      long mem2 = getMem(); // Collect memory information
      System.out.println("Ref size : " + (mem2 - mem1) / array.length + " - (Mem2-Mem1)/array.length");

      for (int i = 0; i < array.length; i++) {
        //array[i] = new Object();
//         array[i] = new String(""); //String pool
//        array[i] = new String(new char[0]); // java8 or java9
        array[i] = new String(new byte[0]); //without String pool = 40
        //array[i] = new MyClass();
        // array[i] = new byte[1]; //16 or 24 with -XX:-UseCompressedOops
//        array[i] = getObject();
      }

      long mem3 = getMem(); // Collect memory information
      System.out.println("Class: " + array[0].getClass().getName() + " size: "
              + (mem3 - mem2) / array.length + " - (Mem3-Mem2)/array.length");
      array = null;
      System.out.println("Array is ready for GC\n");
      Thread.sleep(1000); //wait for 1 sec
    }
  }

  private static Object getObject() {
    return new Object();
  }

  private static long getMem() throws InterruptedException {
    System.gc();
    Thread.sleep(20);
    Runtime runtime = Runtime.getRuntime();
    return runtime.totalMemory() - runtime.freeMemory();
  }

  private static class MyClass {
    private boolean b1 = true;
    private boolean b2 = true;// +1
    private boolean b3 = true;
    private boolean b4 = true;// +1
    private boolean b5 = true;// +1
    //private byte b2 = 0;
    //private byte b3 = 0;     // +1
    //private byte b4 = 0;
    //private byte b5 = 0;
    //private int i = 0;      // +4
    //private long l = 1;     // +8
  }
}
