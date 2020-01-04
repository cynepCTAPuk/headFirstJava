package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        //создаем список для хранения строк
        List<String> list = new ArrayList<String>();

        // открываем файл
        File file = new File("c:/000/berns.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        //пока файл не пуст – читаем из него
        while (reader.ready()) list.add(reader.readLine());

        //закрываем файл
        reader.close();
        list.forEach(System.out::println);
    }
}
