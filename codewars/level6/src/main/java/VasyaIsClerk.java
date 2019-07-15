import java.util.Arrays;

public class VasyaIsClerk {
    public static String Tickets(int[] peopleInLine) {
        int b25 = 0;
        int b50 = 0;
        int b100 = 0;
        for (int i = 0; i < peopleInLine.length; i++) {
            if (peopleInLine[i] == 25) b25++;
            if (peopleInLine[i] == 50) {
                b50++;
                if (b25 > 0) b25--;
                else return "NO";
            }
            if (peopleInLine[i] == 100) {
                if (b50 > 0 & b25 > 0) {
                    b100++;
                    b50--;
                    b25--;
                } else if (b50 == 0 & b25 > 2) {
                    b100++;
                    b25 -= 3;
                } else return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        System.out.println(Tickets(new int[]{25, 25, 50}));
        System.out.println(Tickets(new int[]{25, 100}));
        System.out.println(Tickets(new int[]{25, 25, 50, 50, 100}));
    }

}