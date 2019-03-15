package tasks;

public class chap4_01 {
    public static void main(String[] args) {
        String a = "в леСу Родилась Елочка";
        System.out.println(a);
        String a1 = a.toLowerCase();
        System.out.println(a1);
        String a2 = "";
        String[] b = a1.split(" ");
        for (String s : b) {
            char[] ch = s.toCharArray();
            ch[0] = (char) (ch[0] - 32);
            s = String.valueOf(ch);
            s += " ";
            a2 += s;
        }
        a2 = a2.trim();
        System.out.println(a2 + ".");
    }
}
