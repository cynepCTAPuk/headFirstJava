package chap10;

//: innerclasses/InheritInner.java
// Inheriting an inner class.
class WithInner {
    class Inner {Inner(){
        System.out.println("WithInner.Inner");
    }}
}
public class InheritInner extends WithInner.Inner {
    //! InheritInner() {} // Won’t compile
    InheritInner(WithInner wi) { wi.super(); }

    public static void main(String[] args) {
//        WithInner wi = new WithInner();
//        InheritInner ii = new InheritInner(wi);
        InheritInner ii = new InheritInner(new WithInner());
        System.out.println(ii);
    }
} ///:~