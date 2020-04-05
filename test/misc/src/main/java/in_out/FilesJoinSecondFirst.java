package in_out;

import java.io.*;

public class FilesJoinSecondFirst {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = "C:/000/1.txt";
        String file2 = "C:/000/2.txt";
//        String file1 = bufferedReader.readLine();
//        String file2 = bufferedReader.readLine();

        InputStream fileInputStream;

        fileInputStream = new FileInputStream(file1);
        byte[] buffer1 = new byte[fileInputStream.available()];
        if (fileInputStream.available() > 0) fileInputStream.read(buffer1);
        fileInputStream.close();

        fileInputStream = new FileInputStream(file2);
        byte[] buffer2 = new byte[fileInputStream.available()];
        if (fileInputStream.available() > 0) fileInputStream.read(buffer2);
        fileInputStream.close();

        OutputStream fileOutputStream = new FileOutputStream(file1);
        fileOutputStream.write(buffer2);
        fileOutputStream.write(buffer1);
        fileOutputStream.close();
    }
}

