package inOut;

import java.io.FileInputStream;

public class FileInputStreamTest {
    public static void main(String[] args) throws Exception {
        //создаем объект FileInputStream, привязанный к файлу «c:/data.txt».
        FileInputStream inputStream = new FileInputStream("c:/000/1.txt");
        long sum = 0;

        while (inputStream.available() > 0) {       //пока остались непрочитанные байты
            int data = inputStream.read();      //прочитать очередной байт
            System.out.print(data + " ");
            sum += data;                        //добавить его к общей сумме
        }

        inputStream.close();                    // закрываем поток
        System.out.println("\n" + sum);         //выводим сумму на экран.
    }
}
