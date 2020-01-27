package collections.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
//        String fileName = "c:/000/1.txt";
        TreeSet<Character> set = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String search = "abcdefghijklmnopqrstuvwxyz";
        while (reader.ready()) {
            String line = reader.readLine().toLowerCase();
            for (char first : line.toCharArray()) {
                for (char second : search.toCharArray()) {
                    if (first == second)
                        set.add(first);
                }
            }
        }
        reader.close();
        for (int i = 0; i < 5; i++)
            if (!set.isEmpty())
                System.out.print(set.pollFirst());
    }
}
