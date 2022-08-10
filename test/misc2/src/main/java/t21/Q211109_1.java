package t21;

public class Q211109_1 {
    public static void main(String[] args) {
        Boolean f1 = true;
        Boolean f2 = new Boolean("/false");
        String a = "" + 1 + '+' + 1 + '=' + (1 + 1) + " is ";
        System.out.println(a);
        String b = a + f1 + '/' + f2;
        System.out.println(b);
    }
}

