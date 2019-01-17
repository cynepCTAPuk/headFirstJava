package chap12;
//: exceptions/NeverCaught.java
// Ignoring RuntimeExceptions.
// {ThrowsException}
public class NeverCaught {
    static void f(String string) {
        throw new RuntimeException(string);
    }
    static void g() {
        String string = "From g()";
        f(string);
    }
    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("Catch");
            e.printStackTrace(System.out);
        }
    }
} ///:~