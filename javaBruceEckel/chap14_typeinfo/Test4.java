package chap14_typeinfo;

public class Test4 {
    public static void main(String[] args) {
        int a = 7, b = 3;
        int result = a++ / --b;
        System.out.printf("a = %d, b = %d, result = %d", a, b, result);
    }
}
