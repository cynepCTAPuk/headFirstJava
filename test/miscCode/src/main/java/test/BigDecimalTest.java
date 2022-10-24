package test;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        double d1 = -5.55;
        int intValue = BigDecimal.valueOf(d1).intValue();
        int scale = BigDecimal.valueOf(d1).scale();
        int precision = BigDecimal.valueOf(d1).precision();
        int signum = BigDecimal.valueOf(d1).signum();
        System.out.println(intValue + " | " + scale + " | " + precision + " | " + signum);
    }
}
