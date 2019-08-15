package chap03_Fundamental;

public class Theaetetus {
    public static void main(String[] args) {
        int n1 = (int) (byte) (char) -1;
        int n2 = (int) (char) (byte) -1;
        System.out.println(n1 == n2);
        System.out.println(n1);
        System.out.println(n2);
    }
}
