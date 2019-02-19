//: chap21_concurrency/SerialNumberGenerator.java
package chap21_concurrency;
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static synchronized int nextSerialNumber() {
        return serialNumber++; // Not thread-safe
    }
} ///:~