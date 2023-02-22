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
public class Solution1 {
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
        if (words.length == 0) return new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> tempList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            list.add(words[i]);
            recursion(list, tempList, words);
            list.remove(words[i]);
        }

        for (int i = 0; i < tempList.size(); i++) {
            stringBuilder.append(tempList.get(i));
            if (i != tempList.size() - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder;
    }

    public static void recursion(ArrayList<String> list, ArrayList<String> tempList, String... words) {
        for (int i = 0; i < words.length; i++) {
            String last = list.get(list.size() - 1);
            if (!list.contains(words[i]) && Character.toLowerCase(last.charAt(last.length() - 1))
                    == Character.toLowerCase(words[i].charAt(0))) {
                list.add(words[i]);
                recursion(list, tempList, words);
                list.remove(words[i]);
            }
        }

        if (tempList.size() < list.size()) {
            tempList.clear();
            for (String string : list) {
                tempList.add(string);
            }
        }
    }
}