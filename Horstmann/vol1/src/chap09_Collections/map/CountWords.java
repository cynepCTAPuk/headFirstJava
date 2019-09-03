package chap09_Collections.map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class CountWords {
    public static void main(String[] args) {
        var counts = new TreeMap<String, Integer>();
        File file = new File("c:/000/alice30.txt");
        Pattern pattern = Pattern.compile("[ !\"#$%&'()*+,-./\\:;<=>?@\\[\\]^_`{|}~]");
//        Pattern pattern = Pattern.compile("\\W");
        try (var in = new Scanner(file)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] words = pattern.split(line.toLowerCase());
                for (String word : words) {
//                counts.put(word, counts.getOrDefault(word, 0) + 1);   // 1:
//                counts.putIfAbsent(word, 0);                          // 2:
//                counts.put(word, counts.get(word) + 1);               // 2:
                    counts.merge(word, 1, Integer::sum);              // 3:
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        counts.forEach((k, v) -> System.out.printf("%,3d: %s\n", v, k));

        System.out.println(". . .\n" + counts.size() + " distinct counts. ");
    }
}
