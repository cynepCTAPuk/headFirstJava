package chap10_innerclasses;

//: innerclasses/DotThis.java
// Qualifying access to the outer-class object.
public class DotThis {
    void f() { System.out.println("DotThis.f()"); }
    public class Inner {
        public DotThis outer() {
            return DotThis.this; // A plain "this" would be Inner’s "this"
        }
    }
    public Inner inner() { return new Inner(); }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        System.out.println(dt);
        DotThis.Inner dti = dt.inner();
        System.out.println(dti.outer());
        dti.outer().f();
    }
} /* Output:
DotThis.f()
*///:~