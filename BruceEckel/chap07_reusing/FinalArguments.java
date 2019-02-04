package chap07_reusing;

import static util.Print.print;

//: reusing/FinalArguments.java
// Using "final" with method arguments.
class Gizmo {
    public void spin() {print("spin");}
}
public class FinalArguments {
    void with(final Gizmo g) {
//        g = new Gizmo(); // Illegal -- g is final
    }
    void without(Gizmo g) {
        g = new Gizmo(); // OK -- g not final
        g.spin();
    }
//    void f(final int i) { i++; } // Can’t change
    int g(final int i) { return i + 1; } // You can only read from a final primitive:

    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
        print("final int i plus 1 = " + bf.g(3));
    }
} ///:~