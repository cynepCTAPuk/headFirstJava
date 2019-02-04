package chap07_reusing;
import static util.Print.print;
public class Exercise9 {
    public static void main(String[] args) {
        Stem stem = new Stem();
        stem.dispose();
    }
}

class Root {
    Root() { System.out.println("Root"); }
    Component1 c1 = new Component1();
    Component2 c2 = new Component2();
    Component3 c3 = new Component3();
    void dispose() {
        print("Erasing Root");
        c3.dispose();
        c2.dispose();
        c1.dispose();
    }
}
class Component1 {
    Component1() { System.out.println("Component1"); }
    void dispose() {
        print("Erasing Component1");
    }
}
class Component2 {
    Component2() { System.out.println("Component2"); }
    void dispose() {
        print("Erasing Component2");
    }
}
class Component3 {
    Component3() { System.out.println("Component3"); }
    void dispose() {
        print("Erasing Component3");
    }
}

class Stem extends Root {
    Stem() { System.out.println("Stem"); }
    Component1 c1 = new Component1();
    Component2 c2 = new Component2();
    Component3 c3 = new Component3();
    void dispose() {
        System.out.println("Erasing Stem");
        c3.dispose();
        c2.dispose();
        c1.dispose();
        super.dispose();
    }
}
