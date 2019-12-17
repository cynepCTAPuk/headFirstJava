package inOut;

import java.io.FileInputStream;
import java.io.FileReader;

public class FileReaderTest {
    public static void main(String[] args) throws Exception {
        //создаем объект FileInputStream, привязанный к файлу «c:/data.txt».
        FileReader fileReader = new FileReader("c:/000/1.txt");
        long sum = 0;

        while (fileReader.ready()) {       //пока остались непрочитанные байты
            int data = fileReader.read();      //прочитать очередной байт
            System.out.print(data + " ");
            sum += data;                        //добавить его к общей сумме
        }

        fileReader.close();                    // закрываем поток
        System.out.println("\n" + sum);         //выводим сумму на экран.
    }
}
