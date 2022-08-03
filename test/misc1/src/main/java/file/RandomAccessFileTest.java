package file;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        //r- read, файл открыт только для чтения
        RandomAccessFile raf = new RandomAccessFile("c:/000/amigo.txt", "r");

        String text = raf.readLine(); //читаем строку, начиная с текущего положения курсора и до конца строки
        System.out.println(text);
        raf.seek(100);        //перемещаем «курсор» на 100-й символ.
        text = raf.readLine(); //читаем строку, начиная с текущего положения курсора и до конца строки
        System.out.println(text);

        raf.seek(0);        //перемещаем «курсор» на 100-й символ.
        text = raf.readLine(); //читаем строку, начиная с текущего положения курсора и до конца строки
        System.out.println(text);
        text = raf.readLine(); //читаем строку, начиная с текущего положения курсора и до конца строки
        text = raf.readLine(); //читаем строку, начиная с текущего положения курсора и до конца строки
        System.out.println(text);

        raf.close();        //закрываем файл
    }
}
