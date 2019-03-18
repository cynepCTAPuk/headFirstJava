package capitalizator;
/*
Uppercase first letter in each word and lowercase other letter in String with for each loop
 */
public class chap4_01 {
    public static void main(String[] args) {
        String sOld = "в леСу Родилась Елочка";
        System.out.println(sOld);
        String a1 = sOld.toLowerCase();
        System.out.println(a1);
        String sNew = "";
        String[] sArray = a1.split(" ");
        for (String w : sArray) {
            char[] ch = w.toCharArray();
            ch[0] = (char) (ch[0] - 32);
            w = String.valueOf(ch);
            w += " ";
            sNew += w;
        }
        sNew = sNew.trim();
        System.out.println(sNew + ".");
    }
}
