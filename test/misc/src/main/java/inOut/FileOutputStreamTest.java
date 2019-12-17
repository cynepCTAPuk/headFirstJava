package inOut;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamTest {
    public static void main(String[] args) throws Exception {
        //Создаем поток-чтения-байт-из-файла
        FileInputStream inputStream = new FileInputStream("c:/000/1.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("c:/000/1_1.txt");

        while (inputStream.available() > 0) {   //пока есть еще непрочитанные байты
            int data = inputStream.read();      // прочитать очередной байт в переменную data
            outputStream.write(data);           // и записать его во второй поток
        }

        //закрываем оба потока. Они больше не нужны.
        inputStream.close();
        outputStream.close();
    }
}
