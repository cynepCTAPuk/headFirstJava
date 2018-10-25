package test;

import java.text.*;

public class DecimalFormatDemo {

    static public void customFormat(String pattern, double value) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        System.out.println(value + "\t\t" + pattern + "  " + output);
    }

    static public void main(String[] args) {
        customFormat("000000.000", 12345.67);
        customFormat("###.##", 123456.789);
        customFormat("###,###.###", 123456.789);
        customFormat("$###,###.###", 12345.67);

        System.out.println(new DecimalFormat("###,###.##").format(1234567.890));
        System.out.format("123456.789", "###,###.##");
    }
}