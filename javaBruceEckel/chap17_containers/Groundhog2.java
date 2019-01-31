//: containers/Groundhog2.java
// A class that’s used as a key in a HashMap
// must override hashCode() and equals().
package chap17_containers;
public class Groundhog2 extends Groundhog {
    public Groundhog2(int n) { super(n); }
    public int hashCode() { return number; }
    public boolean equals(Object o) {
        return o instanceof Groundhog2 && (number == ((Groundhog2)o).number);
    }
} ///:~