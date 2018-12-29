package chap03;

public class Exercise13 {
    public static void main(String[] args) {
        char i = 'A' - 1;

        for (int j = 0; j < 50; j++) {
            i++;
            System.out.print(i + " " + Integer.toBinaryString(i) + " " + (int) i+"\t");
            if (j % 5 == 4) System.out.println();
        }
    }
}
