//: generics/GenericMethods.java
package chap15_generics;

public class GenericMethodsEx10 {
    public <T, U> void f(T t, U u, String s) {
        System.out.print(t.getClass().getSimpleName() + " ");
        System.out.print(u.getClass().getSimpleName() + " ");
        System.out.println(s.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethodsEx10 gm = new GenericMethodsEx10();
        gm.f(1, 1.0, "a");
        gm.f(1.0F, 'c', "b");
    }
} /* Output:
java.lang.String
java.lang.Integer
java.lang.Double
java.lang.Float
java.lang.Character
GenericMethods
*///:~