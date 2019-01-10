package chap08;

import static util.Print.print;

//: polymorphism/PolyConstructors.java
// Constructors and polymorphism
// don’t produce what you might expect.
class Glyph {
    void draw() { print("Glyph.draw()"); }
    Glyph() {
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}
class RoundGlyph extends Glyph {
    private int radius = 1;
    RoundGlyph(int radius) {
        this.radius = radius;
        print("RoundGlyph.RoundGlyph(), radius = " + this.radius);
    }
    void draw() { print("RoundGlyph.draw(), radius = " + radius); }
}
class RectangularGlyph extends Glyph {
    private int height = 1;
    private int width = 1;
    RectangularGlyph(int height, int width) {
        this.height = height;
        this.width = width;
        print("RoundGlyph.RoundGlyph(), height = " + this.height + ", width = " + width);
    }
    void draw() { print("RoundGlyph.draw(), height = " + this.height + ", width = " + width); }
}
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
        new RectangularGlyph(10, 20);
    }
} /* Output:
Glyph() before draw()
RoundGlyph.draw(), radius = 0
Glyph() after draw()
RoundGlyph.RoundGlyph(), radius = 5
*///:~