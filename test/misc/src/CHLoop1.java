package src;

public class CHLoop1 {
    public static void main(String[] args) {
        int i = 1500;
        while (1500 <= i && i <= 2700) {
            if (i % 7 == 0 && i % 5 == 0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
