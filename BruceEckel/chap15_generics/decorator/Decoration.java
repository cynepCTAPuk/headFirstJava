//: generics/decorator/Decoration.java
package chap15_generics.decorator;
import java.util.*;
class Basic {
    private String value;
    public void set(String val) { value = val; }
    public String get() { return value; }
}
class Decorator extends Basic {
    protected Basic basic;
    public Decorator(Basic basic) { this.basic = basic; }
    public void set(String val) { basic.set(val); }
    public String get() { return basic.get(); }
}
class TimeStamped extends Decorator {
    private final long timeStamp;
    public TimeStamped(Basic basic) {
        super(basic);
        timeStamp = new Date().getTime();
    }
    public long getStamp() { return timeStamp; }
}
class SerialNumbered extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;
    public SerialNumbered(Basic basic) { super(basic); }
    public long getSerialNumber() { return serialNumber; }
}
public class Decoration {
    public static void main(String[] args) {
        TimeStamped t = new TimeStamped(new Basic());
        System.out.println(t.getStamp());

        try { Thread.sleep(100);
        } catch (InterruptedException e) { e.printStackTrace(); }

        TimeStamped t2 = new TimeStamped( new SerialNumbered(new Basic()));
        System.out.println(t2.getStamp());
        //! t2.getSerialNumber(); // Not available
        SerialNumbered s = new SerialNumbered(new Basic());
        System.out.println(s.getSerialNumber());
        SerialNumbered s2 = new SerialNumbered( new TimeStamped(new Basic()));
        System.out.println(s2.getSerialNumber());
        //! s2.getStamp(); // Not available
    }
} ///:~