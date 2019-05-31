package src;

import java.text.*;

public class DecimalFormatDemo {

    static public void customFormat(String pattern, double value) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        System.out.printf("%,12.4f %12s %12s\n", value, pattern, output);
    }

    static public void main(String[] args) {
        customFormat(" 000,000.000", 123456.789);
        customFormat(" ###,###.###", 123456.789);
        customFormat("$###,###.###", 123456.789);
        System.out.println();

        double f = 123456.789;
        String ff = new DecimalFormat("###,###.###").format(f) + "\tDecimalFormat";
        System.out.println(ff);
    }
}