package io;

import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy4 {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("c:/000/1.txt");
        FileWriter writer = new FileWriter("c:/000/2.txt");

        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = reader.read(); //читаем один символ (char будет расширен до int)
            writer.write(data); //пишем один символ (int будет обрезан/сужен до char)
        }

        //закрываем потоки после использования
        reader.close();
        writer.close();
    }
}
