package puzzle_27;

public class Shifty {
    public static void main(String[] args) {
        int i = 0;
//        while (-1 << i != 0) i++;
//        System.out.println(i);

        int intDistance = 0;
        for (int val = -1; val != 0; val <<= 1) intDistance++;
        System.out.println(intDistance);

        int longDistance = 0;
        for (long val = -1; val != 0; val <<= 1) longDistance++;
        System.out.println(longDistance);
    }
}