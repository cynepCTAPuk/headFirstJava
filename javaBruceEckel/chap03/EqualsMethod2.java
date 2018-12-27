package chap03;

//: operators/EqualsMethod2.java
// Default equals() does not compare contents.
class Value {
    int i;
}

public class EqualsMethod2 {
    public static void main(String[] args) {
        Value v1 = new Value();
        Value v2 = new Value();
        System.out.println(v1);
        v1.i = 100;
        System.out.println(v1);
        System.out.println(v2);
        v2.i = 100;
        System.out.println(v2);
        System.out.println(v1.equals(v2));
        v1 = v2;
        System.out.println(v1.equals(v2));
    }
} /* Output:
false
*///:~