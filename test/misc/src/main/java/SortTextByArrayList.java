package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTextByArrayList {
    public static void main(String[] args) {
        File file = new File("tam.txt");
        List<String> list = new ArrayList();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) list.add(line);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Collections.sort(list);
        for (String str : list) System.out.println(str);
    }
}
