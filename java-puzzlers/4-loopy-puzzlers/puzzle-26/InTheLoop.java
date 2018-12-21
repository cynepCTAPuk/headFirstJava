public class InTheLoop {
    public static final int END = Integer.MAX_VALUE;
    public static final int START = END - 100;

    public static void main(String[] args) {
        int count = 1;
        System.out.println("END = Integer.MAX_VALUE =\t" + END);
        System.out.println("START = END - 100 =\t\t\t" + START);

        for (int i = START; i <= END; i++) {
            if (count % 5 == 1) System.out.println();
            System.out.format("%3d - %d\t", count, i);
            count++;

            if (count > 110) {
                System.out.println("*****");
                break;
            }
        }
    }
}
