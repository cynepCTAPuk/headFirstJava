//: generics/GenericMethods.java
package chap15_generics;

public class GenericMethodsEx9 {
    public <T, U, V> void f(T t, U u, V v) {
        System.out.println(t.getClass().getName());
        System.out.println(u.getClass().getName());
        System.out.println(v.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethodsEx9 gm = new GenericMethodsEx9();
        gm.f("", 1, 1.0);
        gm.f(1.0F, 'c', gm);
        System.out.println((int) 'T' + " " + (char) ('T' + 1) + " " + (char) ('T' + 2));
    }
} /* Output:
java.lang.String
java.lang.Integer
java.lang.Double
java.lang.Float
java.lang.Character
GenericMethods
*///:~