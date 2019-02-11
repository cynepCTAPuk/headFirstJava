//: enumerated/TrafficLight.java
// Enums in switch statements.
package chap19_enumerated;
import static chap19_enumerated.Signal.*;
import static util.Print.*;

public class Exercise1 {
    public static void main(String[] args) {
        Signal color = RED;

        for (int i = 0; i < 7 ; i++) {
            switch(color) {
                case RED: color = GREEN; print(color); break;
                case GREEN: color = YELLOW; print(YELLOW); break;
                case YELLOW: color = RED; print(RED); break;
            }
        }
    }
}
