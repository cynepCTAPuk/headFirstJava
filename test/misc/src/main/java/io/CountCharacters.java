package io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountCharacters {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<>();
/*
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
*/
        String file = "c:/000/berns.txt";
        try (InputStream fileInputStream = new FileInputStream(file);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            while (bufferedReader.ready()) list.add(bufferedReader.readLine().toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Character character : alphabet) {
            int qty = 0;
            for (String s : list) {
                for (Character ch : s.toCharArray()) {
                    if (ch.equals(character)) qty++;
                }
            }
            System.out.println(character + " " + qty);
        }
    }
}