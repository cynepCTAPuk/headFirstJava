public class Clock {
    public static void main(String[] args) {
        int minutes = 0;
        for (int ms = 0; ms < 60 * 60 * 1000; ms++) {

            if (ms % (60 * 1000) == 0) {
                System.out.print(ms + " ");
                minutes++;
            }
        }
        System.out.println();
        System.out.println(minutes);
    }
}
