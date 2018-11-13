package level02.lecture09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
  public static void main(String[] args) throws IOException {
    FileInputStream fileInputStream =
            new FileInputStream("c:\\000\\data.txt");
    FileOutputStream fileOutputStream =
            new FileOutputStream("c:\\000\\result.txt");

    while (fileInputStream.available() > 0) {
      int data = fileInputStream.read();
      fileOutputStream.write(data);
    }
    byte[] bytes = "=End of File=\n".getBytes();
    fileOutputStream.write(bytes);
    fileOutputStream.write("Hello World!\n".getBytes());

    fileInputStream.close();
    fileOutputStream.close();
  }
}