package file;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest1 {
    public static void main(String[] args) throws IOException {
        //rw- read/write, файл открыт и для чтения и для записи
        RandomAccessFile raf = new RandomAccessFile("c:/000/seek.txt", "rw");

        String text = raf.readLine();
        System.out.println(text);
        raf.writeBytes("It is a string"); //пишем в файл строку, начиная с 0-го байта

        raf.seek(0);
        text = raf.readLine();
        System.out.println(text);

        raf.seek(8);                    //ставим курсор на 8-й символ
        raf.writeBytes("surprise!");      //печатаем в файл строку surprise!

        raf.seek(0);
        text = raf.readLine();
        System.out.println(text);

        raf.close();                         //закрываем файл
    }
}
