package src;

import java.io.IOException;
import java.util.Date;

public class ProgressPercentage {
    private static int start = 0;
    private static int finish = 50;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <= 200; i = i + 20) {
            progressPercentage(i, 200);
            Thread.sleep(500);
        }
        loading("Calculating ...");
        delay(10_000);
    }

    public static void progressPercentage(int remain, int total) {
        if (remain > total) throw new IllegalArgumentException();

        int maxBareSize = 10; // 10unit for 100%
        int remainProcent = ((100 * remain) / total) / maxBareSize;
        char defaultChar = '-';
        String icon = "*";
        String bare = new String(new char[maxBareSize]).replace('\0', defaultChar) + "]";
        StringBuilder bareDone = new StringBuilder();
        bareDone.append("[");

        for (int i = 0; i < remainProcent; i++) bareDone.append(icon);
        String bareRemain = bare.substring(remainProcent, bare.length());
        System.out.print("\r" + bareDone + bareRemain + " " + remainProcent * 10 + "%");

        if (remain == total) System.out.print("\n");
    }

    private static synchronized void loading(String msg) {
        System.out.println(msg);
        Thread thread = new Thread(() -> {
            try {
                System.out.print("|");
                while (start++ < finish) {
                    System.out.print("-");
                    Thread.sleep(500);
                }
                System.out.print("| Done\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    private static void delay(long milliseconds) {
        String bar = "[--------------------]";
        String icon = "X";

        long startTime = new Date().getTime();
        boolean bouncePositive = true;
        int barPosition = 0;

        while ((new Date().getTime() - startTime) < milliseconds) {
            if (barPosition < bar.length() && barPosition > 0) {
                String b1 = bar.substring(0, barPosition);
                String b2 = bar.substring(barPosition);
                System.out.print("\r Delaying: " + b1 + icon + b2);
                if (bouncePositive) barPosition++;
                else barPosition--;
            }
            if (barPosition == bar.length()) {
                barPosition--;
                bouncePositive = false;
            }
            if (barPosition == 0) {
                barPosition++;
                bouncePositive = true;
            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
        System.out.print("\n");
    }
}