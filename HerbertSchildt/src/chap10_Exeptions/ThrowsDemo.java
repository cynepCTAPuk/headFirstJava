package chap10_Exeptions;

// This program contains an error and will not compile
public class ThrowsDemo {
    static void throwOne() {
        System.out.println("Inside throwOne");
//        throw new IllegalAccessException("demo");
    }

    public static void main(String[] args) {
        throwOne();
    }
}
