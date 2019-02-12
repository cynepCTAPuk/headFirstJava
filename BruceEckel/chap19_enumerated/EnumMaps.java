//: enumerated/EnumMaps.java
// Basics of EnumMaps.
package chap19_enumerated;
import java.util.*;
import static chap19_enumerated.AlarmPoints.*;
import static util.Print.*;
interface Command { void action(); }
public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints,Command> em = new EnumMap<>(AlarmPoints.class);
        System.out.println("1: " + em);

        em.put(KITCHEN, new Command() {
            public void action() { print("Kitchen fire!"); }
        });
        System.out.println("2: " + em);

        em.put(BATHROOM, new Command() {
            public void action() { print("Bathroom alert!"); }
        });
        System.out.println("3: " + em);

        for(Map.Entry<AlarmPoints,Command> e : em.entrySet()) {
            printnb(e.getKey() + ": ");
            e.getValue().action();
        }
        try { // If there’s no value for a particular key:
            em.get(UTILITY).action();
        } catch(Exception e) {
            print(e);
        }
        System.out.println("4: " + em);
    }
} /* Output:
BATHROOM: Bathroom alert!
KITCHEN: Kitchen fire!
java.lang.NullPointerException
*///:~