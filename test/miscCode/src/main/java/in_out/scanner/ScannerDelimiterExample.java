package in_out.scanner;

import java.util.Scanner;

public class ScannerDelimiterExample {
    public static void main(String[] args) {
        String source = "1,3; 1 ;2,0;\n  8.5  ; 4,8;\n 1 9,0;  10; abc";
        double sum = 0d;
        try (Scanner scanner = new Scanner(source)) {
            scanner.useDelimiter("\\s*;\\s*");
            int count = 0;
            while (scanner.hasNext()) {
                System.out.printf("%02d ", ++count);
                if (scanner.hasNextDouble()) {
                    double number = scanner.nextDouble();
                    System.out.println("Число = " + number);
                    sum += number;
                } else System.out.println("Строка: " + scanner.next());
            }
        }
        System.out.println("Сумма чисел = " + sum);
    }
}