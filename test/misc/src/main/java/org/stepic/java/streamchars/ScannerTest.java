package org.stepic.java.streamchars;

import java.io.Reader;
import java.io.StringReader;
import java.util.Locale;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Reader reader = new StringReader("abc|true|1,1e-2|-42");

        Scanner scanner = new Scanner(reader)
                .useDelimiter("\\|")
                .useLocale(Locale.forLanguageTag("ru"));
//                .useLocale(Locale.ENGLISH);

        String token = scanner.next();
        boolean bool = scanner.nextBoolean();
        double dbl = scanner.nextDouble();
        int integer = scanner.nextInt();

        System.out.println(token + " " + bool + " " + dbl + " " + integer);

        scanner = new Scanner(System.in);
        double sum = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
            } else {
                scanner.next();
            }
        }
        System.out.printf(Locale.US, "%.6f", sum);
    }
}
