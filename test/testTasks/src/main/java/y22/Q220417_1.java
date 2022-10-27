package y22;

public class Q220417_1 {
    public static void main(String[] args) {
//        System.out.println(new Q220417_1().ivade( 7));
        System.out.println(new Q220417_1().ivade((short) 7));
        System.out.println(new Q220417_1().ivade((short) 7, (short) 8));
    }

    String ivade(short ships) {
        return "a few";
    }

    String ivade(short... ships) {
        return "many";
    }
}

