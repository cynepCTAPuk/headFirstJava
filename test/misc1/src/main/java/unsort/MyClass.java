package unsort;

public class MyClass {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        System.out.print(o1.equals(o1 = o2));
        System.out.print(" ");
        System.out.print(o2.equals(o3 = o1));
        System.out.print(" ");
        System.out.print(o1 == o3);
    }
}
