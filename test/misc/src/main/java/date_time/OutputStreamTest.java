package date_time;

import java.io.*;
import java.util.ArrayList;

public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
        MyClass outClass = new MyClass();
        outClass.write(1);
        outClass.write(2);
        outClass.write(3);

        OutputStream outStream = new FileOutputStream("c:/000/my-object-data.txt");
        while (outClass.available() > 0) {
            int data = outClass.read(); //читаем один int из потока для чтения
            outStream.write(data); //записываем прочитанный int в другой поток.
        }
        outStream.close();


        MyClass inClass = new MyClass();
        InputStream inStream = new FileInputStream("c:/000/my-object-data.txt");
        while (inStream.available() > 0) {
            int data = inStream.read(); //читаем один int из потока для чтения
            inClass.write(data); //записываем прочитанный int в другой поток.
        }
        inStream.close(); //закрываем потоки

        System.out.println(inClass.available());
    }
}

class MyClass {
    private ArrayList<Integer> list = new ArrayList();

    public void write(int data) {
        list.add(data);
    }

    public int read() {
        int first = list.get(0);
        list.remove(0);
        return first;
    }

    public int available() {
        return list.size();
    }
}
