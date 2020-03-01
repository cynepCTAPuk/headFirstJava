package io.task2211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Смена кодировки
*/
public class Solution1 {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Solution fileIn fileOut");
        } else {
            String in = args[0];
            String out = args[1];
            Charset windows1251 = Charset.forName("Windows-1251");
            Charset utf8 = StandardCharsets.UTF_8;
            BufferedReader reader = Files.newBufferedReader(Paths.get(in), windows1251);
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(out), utf8);

            while (reader.ready()) {
                String data = reader.readLine();
                System.out.println(data);
                writer.write(data);
            }
            writer.close();
            reader.close();
        }
    }
}
