package vasilievAN;

import java.util.*;

public class StringTokenizerDemo {
    public static void main(String[] args) {
        String text = "Очень простой текст: состоит из слов, и без цифр!"; // Базовый текст:
        StringTokenizer str = new StringTokenizer(text); // Объект класса StringTokenizer:
        String s; // Текстовая переменная:
        while (str.hasMoreTokens()) {
            s = str.nextToken(); // "Считывание" очередного слова:
            // s=str.nextToken(" :,!");
            // s=str.nextToken(":,!");
            System.out.println(s); // Вывод слова на экран:
        }
    }
}