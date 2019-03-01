package puzzle_26;

public class InTheLoop {
    public static final int END = Integer.MAX_VALUE;
    public static final int START = END - 100;

    public static void main(String[] args) {
        int count = 0;
/*
        for (int i = START; i <= END; i++) // infinity loop
            count++;
        System.out.println(count);
*/

        int i = START;
        do count++; while (i++ != END);
        System.out.println(count);
    }
}