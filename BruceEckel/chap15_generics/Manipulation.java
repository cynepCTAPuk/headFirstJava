//: generics/Manipulation.java
// {CompileTimeError} (Won’t compile)
package chap15_generics;
class Manipulator<T> {
    private T obj;
    public Manipulator(T x) { obj = x; }
//    public void manipulate() { obj.f(); } // Error: cannot find symbol: method f():
}
class Manipulator2<T extends HasF> {
    private T obj;
    public Manipulator2(T x) { obj = x; }
    public void manipulate() { obj.f(); }
}
class Manipulator3 {
    private HasF obj;
    public Manipulator3(HasF x) { obj = x; }
    public void manipulate() { obj.f(); }
}
public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
//        manipulator.manipulate();

        Manipulator2<HasF> manipulator2 = new Manipulator2<>(hf);
        manipulator2.manipulate();

        Manipulator3 manipulator3 = new Manipulator3(hf);
        manipulator3.manipulate();
    }
} ///:~