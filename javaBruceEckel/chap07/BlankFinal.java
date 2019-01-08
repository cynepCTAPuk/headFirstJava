package chap07;

import static util.Print.print;
import static util.Print.printf;

//: reusing/BlankFinal.java
// "Blank" final fields.
class Poppet {
    private int i;
    Poppet(int ii) { i = ii; }
}
public class BlankFinal {
    private final int i = 0; // Initialized final
    private final int j; // Blank final
    private final Poppet p; // Blank final reference
    // Blank finals MUST be initialized in the constructor:
    public BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet(1); // Initialize blank final reference
    }
    public BlankFinal(int x) {
        j = x; // Initialize blank final
        p = new Poppet(x); // Initialize blank final reference
    }

    @Override
    public String toString() {
        return String.format("BlankFinal{i=%2d, j=%2d, p=%s}", i , j ,p);
    }

    public static void main(String[] args) {
        print(new BlankFinal());
        print(new BlankFinal(47));
    }
} ///:~