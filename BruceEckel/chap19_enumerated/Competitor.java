//: enumerated/Competitor.java
// Switching one enum on another.
package chap19_enumerated;
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
} ///:~