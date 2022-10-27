package y22;

public class Q221017_1 {
//    public static void m(A a) {        System.out.println("a");    }
//    public static void m(B b) {        System.out.println("b");    }
    public void m(A a) {        System.out.println("a");    }
    public void m(B b) {        System.out.println("b");    }

    public static void main(String[] args) {
//        m.new C();
        new Q221017_1().m(new C());
    }
}

class A {}
class B extends A {}
class C extends B {}

