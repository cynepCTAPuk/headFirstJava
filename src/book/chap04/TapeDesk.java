/*
 * Copyright (c) 2018/7/1 11:39
 * CTAPuk
 */

package book.chap04;

public class TapeDesk {
    boolean canRecord = false;

    void playTape() {
        System.out.println("плёнка проигрывается");
    }

    void recortTape() {
        System.out.println("идёт запись на плёнку");
    }
}

class TapeDeskTestDrive {
    public static void main(String[] args) {
        TapeDesk t = new TapeDesk();

        t.canRecord = true;
        t.playTape();
        if (t.canRecord == true) t.recortTape();
    }
}
