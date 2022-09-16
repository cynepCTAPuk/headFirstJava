package integer;

public class DoubleToLong {
    public static void main(String[] args) {
//        long lBits = Double.doubleToLongBits(-0.06);
        double d = Double.MAX_VALUE;
//        d = -0x1p10;
        d = -1024.0;
        long lBits = Double.doubleToLongBits(d);
        long lSign = lBits >>> 63; // знак
        long lExp = (lBits >>> 52 & (1 << 11) - 1) - ((1 << 10) - 1); // порядок
        long lMantissa = lBits & ((1L << 52) - 1); // мантисса
        System.out.printf("Double.Max     : %1.16e%n" +
                        "Long.Max       : %,d%n" +
                        "DoubleToLong   : %,d%n",
                Double.MAX_VALUE, Long.MAX_VALUE, lBits);
        System.out.printf("sign: %d exp: %,d mantissa: %,d%n", lSign, lExp, lMantissa);
        System.out.println(Double.longBitsToDouble((lSign << 63) | (lExp + ((1 << 10) - 1)) << 52 | lMantissa));
        System.out.println("-".repeat(50));

        float f = Float.MAX_VALUE;
        f = -1024.0f;
        int iBits = Float.floatToIntBits(f);
        int iSign = iBits >>> 31; // знак
        int iExp = (iBits >>> 23 & (1 << 8) - 1) - ((1 << 7) - 1); // порядок
        int iMantissa = iBits & ((1 << 23) - 1); // мантисса
        System.out.printf("Float.Max      : %1.16e%n" +
                        "Integer.Max    : %,d%n" +
                        "FloatToInteger : %,d%n",
                Float.MAX_VALUE, Integer.MAX_VALUE, iBits);
        System.out.printf("sign: %d exp: %,d mantissa: %,d%n", iSign, iExp, iMantissa);
        System.out.println(Float.intBitsToFloat((iSign << 31) | (iExp + ((1 << 7) - 1)) << 23 | iMantissa));
//        System.out.println(Float.intBitsToFloat(iBits));
    }
}