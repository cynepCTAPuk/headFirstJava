package chap21_concurrency;

import java.util.*;

public class Exercise14 implements Runnable{
    int i = 0;
    public int getI() { return i;}
    void add() { i++;}
    public void run() { add();}

    public static void main(String[] args) {
        Exercise14 ex = new Exercise14();
        Timer timer = new Timer();
    }

}
