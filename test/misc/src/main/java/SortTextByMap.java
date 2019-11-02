package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class SortTextByMap {
    public static void main(String[] args) {
        File file = new File("tam.txt");
        Map<String, String> list = new TreeMap();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strings = line.split(" ");
                list.put(strings[1], line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (String key : list.keySet()) System.out.println(list.get(key));
    }
}
