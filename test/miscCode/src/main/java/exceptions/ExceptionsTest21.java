package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsTest21 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("C:\\000\\test.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка! Файл не найден!");
            e.printStackTrace();
        }
        String firstString = null;
        try {
            firstString = reader.readLine();
        } catch (IOException e) {
            System.out.println("Ошибка при вводе/выводе данных из файла!");
            e.printStackTrace();
        }
        System.out.println(firstString);
    }
}
