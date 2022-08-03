package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsTest22 {
    public static void main(String[] args) throws IOException {
        int a = 366, b = 0;
        try {
            System.out.println(a / b);

            BufferedReader reader = new BufferedReader(new FileReader("C:\\000\\test.txt"));
            String firstString = reader.readLine();
            System.out.println(firstString);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка! Файл не найден!");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка! Деление на ноль!");
        }
    }
}
