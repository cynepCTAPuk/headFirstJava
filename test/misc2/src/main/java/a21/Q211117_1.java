package aaa;

public class Q211117_1 {

    public static void main(String[] args) {
        int a[] = new int[100];
        for (int i = 0, j = 100; i < 100; i++, j--) {
            a[i] = i + j;
        }
        System.out.println(a[50]);
        System.out.println(a[51]);
        System.out.println(a[52]);
    }
}

