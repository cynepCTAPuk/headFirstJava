package chap18_io;

import util.*;

import java.io.*;
import java.util.*;

public class Exercise19 {
    public static void main(String[] args) throws IOException {
        String file = "chap18_io/Exercise19.java";
        byte[] bytes = BinaryFile.read(file);

        TreeMap<Byte, Integer> treeMap = new TreeMap<>();
        for (Byte b : bytes) {
            char c = Character.highSurrogate(b);
            if (treeMap.containsKey(b)) treeMap.put(b, treeMap.get(b) + 1);
            else treeMap.put(b, 1);
        }
        System.out.println(treeMap);
    }
}
