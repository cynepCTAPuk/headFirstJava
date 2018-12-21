public class InTheLoop {
    public static final int END = Integer.MAX_VALUE;
    public static final int START = END - 100;

    public static void main(String[] args) {
        int count = 0;
        System.out.println("END = Integer.MAX_VALUE =\t" + END);
        System.out.println("START = END - 100 =\t\t\t" + START);

        for (int i = START; i < END; i++) {
            System.out.print(i + "\t");
            count++;
            if (count > 200) {
                System.out.println("*****");
                break;
            }
        }
/*
        for (int i = 0; i <= 100; i++) {
            System.out.print(END - i + "\t");
        }
*/
    }
}
