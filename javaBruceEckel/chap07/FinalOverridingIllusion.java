package chap07;

import static util.Print.print;

//: reusing/FinalOverridingIllusion.java
// It only looks like you can override
// a private or private final method.
class WithFinals {
    private final void f() { print("WithFinals.f()"); } // Identical to "private" alone:
    private void g() { print("WithoutFinals.g()"); } // Also automatically "final":
}
class OverridingPrivate extends WithFinals {
    private final void f() { print("OverridingPrivate.f()"); }
    private void g() { print("OverridingPrivate.g()"); }
}
class OverridingPrivate2 extends OverridingPrivate {
    public final void f() { print("OverridingPrivate2.f()"); }
    public void g() { print("OverridingPrivate2.g()"); }
}
public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();

// You can upcast:
        OverridingPrivate op1 = op2;
// But you can’t call the methods:
// op1.f();
// op1.g();

// Same here:
        WithFinals wf = op2;
// wf.f();
// wf.g();
    }
} /* Output:
OverridingPrivate2.f()
OverridingPrivate2.g()
*///:~