package book.chap11;

import static book.chap11.MyEx.doRisky;

public class ExTestDrive {
    public static void main(String[] args) {
        String test = args[0];
        try {
            doRisky(test);
        } catch (MyEx e) {
            System.out.print("a");
        } finally {
            System.out.print("w");
            System.out.print("s");
        }
    }
}

class MyEx extends Exception {

    static void doRisky(String t) throws MyEx {
        System.out.print("t");
        System.out.print("h");
        if ("yes".equals(t)) {
            throw new MyEx();
        }
        System.out.print("r");
        System.out.print("o");
    }

}
