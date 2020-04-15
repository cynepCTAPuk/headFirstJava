package org.stepic.java.streambytes;

import java.util.Scanner;

public class ConvertFileSeparator1 {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in).useDelimiter("\\A")) {
            System.out.println(
                    (s.hasNext() ? s.next() : "").replace("\r\n", "\n")
            );
        }
    }
}