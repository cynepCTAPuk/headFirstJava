package oop;

import java.math.BigDecimal;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        long time = timer.measureTime(TimerTest::bigDecimalPower);
        System.out.println(time);
    }

    private static void bigDecimalPower() {
        System.out.println(new BigDecimal("1234567").pow(100_000));
    }

/*
    private static class BigDecimalPower implements Runnable {
        @Override
        public void run() {
            new BigDecimal("1234567").pow(1_000_000);
        }
    }
*/
}
