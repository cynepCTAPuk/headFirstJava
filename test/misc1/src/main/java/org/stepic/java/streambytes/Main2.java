package org.stepic.java.streambytes;

import java.io.*;

public class Main2 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String string;
            double sum = 0;
            while ((string = reader.readLine()) != null) {
                for (String s : string.split(" ")) {
                    try {
                        sum += Double.parseDouble(s);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
            System.out.printf("%.6f%n", sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
