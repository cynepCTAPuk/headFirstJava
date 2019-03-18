package capitalizator;

public class chap4_03 {
    public static void main(String[] args) {
        String a = "в леСу Родилась еЛОчка";
        System.out.println(a);
        StringBuilder a1 = new StringBuilder();
        int i = 0;
        while (i < a.length()) {
            String c = a.substring(i, i + 1);
            if (i == 0 || (a.charAt(i - 1) == ' ')) c = c.toUpperCase();
            else c = c.toLowerCase();
            a1.append(c);
            i++;
        }
        System.out.println(a1);
    }
}
