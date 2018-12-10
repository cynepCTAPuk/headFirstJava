package test;

public class ASCII {
    public static void main(String[] args) {
        int a = 33;         //start symbol
        int b = 300;        //qty all symbols
        int c = 20;         // qty symbols in row
        int n = 0;
        for (int i = a; i < a + b; i++) {
            System.out.format("%,3d ", i);
            System.out.format("%2c\t", (char) i);
            if (++n % c == 0) System.out.format("%n");
        }
//        System.out.println();
    }
}
