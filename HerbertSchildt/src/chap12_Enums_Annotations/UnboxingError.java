package chap12_Enums_Annotations;

// An error produced by manual unboxing
public class UnboxingError {
    public static void main(String[] args) {
        Integer iOb = 1_000; // autobox the value 1000
        int i = iOb.byteValue(); // manually unbox as byte !!!
        System.out.println(i);
    }
}
