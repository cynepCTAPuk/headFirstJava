package string.task2207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();
        bufferedReader.close();
        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        List<String> words = new ArrayList<>();
        for (String line : lines) words.addAll(Arrays.asList(line.split(" ")));
        for (int i = 0; i < words.size(); i++) {
            String first = words.get(i);
            String reverseFirst = new StringBuilder(first).reverse().toString();
            for (int j = i + 1; j < words.size(); j++) {
                String second = words.get(j);
                if (reverseFirst.equals(second)) {
                    Pair pair = new Pair();
                    pair.first = first;
                    pair.second = second;
                    if (!result.contains(pair))
                        result.add(pair);
                }
            }
        }
//        System.out.println(result);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }
}
