package chap08_polymorphism;

import static util.Print.print;

//: polymorphism/RTTI.java
// Downcasting & Runtime type information (RTTI).
// {ThrowsException}
class Useful {
    public void f() { print("f"); }
    public void g() { print("g"); }
}
class MoreUseful extends Useful {
    public void f() { print("ff"); }
    public void g() { print("gg"); }
    public void u() { print("uu"); }
    public void v() { print("vv"); }
    public void w() { print("ww"); }
}
public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new MoreUseful()
        };
        x[0].f();
        x[1].g();
//        Compile time: method not found in Useful:
//        x[1].u();
        ((MoreUseful)x[1]).u(); // Downcast/RTTI
//        ((MoreUseful)x[0]).u(); // Exception thrown
    }
} ///:~