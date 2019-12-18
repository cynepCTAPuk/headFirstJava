package inOut;

import java.io.FileInputStream;

public class FileInputStreamTest {
    public static void main(String[] args) throws Exception {
        //создаем объект FileInputStream, привязанный к файлу «c:/data.txt».
        FileInputStream fis = new FileInputStream("c:/000/1.txt");
        long sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (fis.available() > 0) {       //пока остались непрочитанные байты
            int data = fis.read();      //прочитать очередной байт
            System.out.print(data + " ");
            sum += data;                        //добавить его к общей сумме
            if (data > max) max = data;
            if (data < min) min = data;
        }

        fis.close();                    // закрываем поток
        System.out.println("\n" + "sum: " + sum);         //выводим сумму на экран.
        System.out.println("min: " + min + " max: " + max);
    }
}
