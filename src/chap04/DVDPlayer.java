/*
 * Copyright (c) 2018/7/1 11:39
 * CTAPuk
 */

package chap04;

public class DVDPlayer {
    boolean canRecord = false;

    void playDVD() {
        System.out.println("DVD проигрывается");
    }

    void recordDVD() {
        System.out.println("идёт запись DVD");
    }
}

class DVDPlayerTestDrive{
    public static void main(String[] args) {
        DVDPlayer d = new DVDPlayer();
        d.canRecord = true;
        d.playDVD();

        if(d.canRecord==true) d.recordDVD();
    }
}