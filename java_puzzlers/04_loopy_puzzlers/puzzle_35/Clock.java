package puzzle_35;

public class Clock {
    public static void main(String[] args) {
        int minutes = 0;
        for (int ms = 0; ms < 60 * 60 * 1_000; ms++)
            if (ms % 60 * 1_000 == 0) {
                System.out.printf("%,d ", ms);
                minutes++;
            }
        System.out.printf("\n%,d", minutes);
    }
}
