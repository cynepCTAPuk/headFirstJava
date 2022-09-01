package t21;

import java.util.Arrays;

public class Q210226_1 {
    public static void main() {
        System.out.println("A");
    }
    public static void main(String args) {
        System.out.println("B");
    }
    public static void main(String[] args) {
        System.out.println("C");
        int[] a = {1, 2, 3};
        Arrays.stream(a).forEach(el -> System.out.print(el + " "));
        System.out.println();
        System.out.println(a.length);
    }
}
