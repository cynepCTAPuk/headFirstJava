package chap14_typeinfo;

public class Test4 {
    public static void main(String[] args) {
        int a = 7, b = 3;
        int c = a++ / --b;
        System.out.printf("a = %d, b = %d, c = %d", a, b, c);
        Integer i = 10;
        System.out.println(i.TYPE);
    }
}
