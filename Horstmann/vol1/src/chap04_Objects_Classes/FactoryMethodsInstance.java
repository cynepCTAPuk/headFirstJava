package chap04_Objects_Classes;

import java.text.NumberFormat;
import java.util.Locale;

public class FactoryMethodsInstance {
    public static void main(String[] args) {
        double x = 0.1;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

        System.out.println(currencyFormatter.format(x));
        currencyFormatter = NumberFormat.getCurrencyInstance(Locale.UK);
        System.out.println(currencyFormatter.format(x));
        currencyFormatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println(currencyFormatter.format(x));

        NumberFormat percentFormatter = NumberFormat.getPercentInstance();

        System.out.println(percentFormatter.format(x));
    }
}
