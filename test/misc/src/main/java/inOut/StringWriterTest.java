package inOut;

import java.io.*;

public class StringWriterTest {
    public static void main(String[] args) throws Exception {
        //эту строку должен будет прочитать Reader
        String test = "Hi!\n My name is Richard\n I'm a photographer\n";
        Reader reader = new StringReader(test);     //заворачиваем строку в StringReader
        Writer writer = new StringWriter();         //Создаем объект StringWriter
        executor(reader, writer);        //переписываем строки из Reader во Writer, предварительно развернув их
        String result = writer.toString();          //получаем текст, который был записан во Writer
        System.out.println("Результат: " + result); //выводем полученный из Writer’а текст на экран
    }

    private static void executor(Reader reader, Writer writer) throws Exception {
        BufferedReader br = new BufferedReader(reader);
        String line;

        //читаем строку из Reader’а
        while ((line = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder(line); //разворачиваем строку задом наперед
            String newLine = sb.reverse().toString();
            writer.write(newLine);                      //пишем строку в Writer
        }
    }
}
