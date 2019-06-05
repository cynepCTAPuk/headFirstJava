package ru.otus.l71.structural.decorator;

/**
 * Created by tully.
 */
public class Main {
    public static void main(String[] args) {
        Printer normalPrinter = new PrinterImpl();
        normalPrinter.print("Test");

        Printer decorator = new PrinterDecorator(normalPrinter);
        decorator.print("Decorator does nothing\n");

        Printer reversedPrinter = new ReversedPrinter(normalPrinter);
        Printer underscorePrinter = new UnderscorePrinter(normalPrinter);
        Printer upperCasePrinter = new UpperCasePrinter(normalPrinter);

        normalPrinter.print("Optional wrapper in the Decorator pattern.");
        underscorePrinter.print("Optional wrapper in the Decorator pattern.");
        reversedPrinter.print("Optional wrapper in the Decorator pattern.");
        upperCasePrinter.print("Optional wrapper in the Decorator pattern.\n");

        Printer upperReversedPrinter = new UpperCasePrinter(reversedPrinter);
        upperReversedPrinter.print("Optional wrapper in the Decorator pattern.");

        Printer upperReversedUnderscorePrinter = new UnderscorePrinter(upperReversedPrinter);
        upperReversedUnderscorePrinter.print("All printers");
    }
}
