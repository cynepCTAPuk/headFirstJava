package puzzle_34;

public class Count {
    public static void main(String[] args) {
        final int START = 2_000_000_000;
        int count = 0;
        for (float f = START; f < START + 50; f++) {
            count++;
            System.out.print(count + " ");
        }
        System.out.printf("%,d\n", START);
        System.out.printf("%,d\n", Integer.MAX_VALUE);
        System.out.println(count);

        float e = START;
        System.out.println(e == e + 50);
    }
}
