package io;

import java.io.*;
import java.util.*;

public class FileTest {
    public static void main(String[] args) {
        File f = new File("c:/000/content.txt");
        File f1 = new File("c:/000/");
        if(f.exists()) System.out.println("Exist");
        if(f1.isDirectory()) System.out.println("Directory");
        System.out.println(Arrays.toString(f1.list()));
        System.out.println(Arrays.asList(f1.list()));
    }
}
