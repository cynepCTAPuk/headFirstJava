package book.chap04;

public class MixFor5 {
    public static void main(String[] args) {
        int x = 0;
        int y = 30;
        for (int outer = 0; outer < 3; outer++) {
            for (int inner = 4; inner > 1; inner--) {
                x--;        //*******
                y = y - 2;
                if (x == 6) {
                    break;
                }
                x = x + 3;
            }//end for inner
            y = y - 2;
        }//end for outer
        System.out.println(x + " " + y);
    }//end main
}//end class
