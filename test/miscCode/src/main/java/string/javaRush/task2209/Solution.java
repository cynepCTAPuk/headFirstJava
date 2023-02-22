package string.javaRush.task2209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();
        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        List<String> words = new ArrayList<>();
        for (String line : lines) words.addAll(Arrays.asList(line.split(" ")));
        String[] array = new String[words.size()];
        Arrays.setAll(array, words::get);

        StringBuilder result = getLine(array);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) return new StringBuilder();
        if (words.length == 1) return new StringBuilder(words[0]);
        String[] array = new String[words.length];
        for (int i = 0; i < array.length; i++) array[i] = words[i];
        int n = 0, ctrl = 0;
        while (true) {
            StringBuilder result = new StringBuilder(array[0]);
            for (int i = 1; i < array.length; i++) {
                String previousWord = array[i - 1];
                String currentWord = array[i];
//                String endPreviousWord = previousWord.toLowerCase().substring(previousWord.length() - 1);
//                String startCurrentWord = currentWord.toLowerCase().substring(0, 1);
                char endPreviousWord = previousWord.toLowerCase().charAt(previousWord.length() - 1);
                char startCurrentWord = currentWord.toLowerCase().charAt(0);
//                if (endPreviousWord.equals(startCurrentWord)) {
                if (endPreviousWord == (startCurrentWord)) {
                    ++n;
                    result.append(' ').append(currentWord);
                } else {
                    n = 0;
                    break;
                }
            }
            if (n == words.length - 1) {
                System.out.println(ctrl);
                return result;
            }
            Collections.shuffle(Arrays.asList(array));
            if (++ctrl > 1_000) return new StringBuilder();
        }
    }
}
