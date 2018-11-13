package level02.lecture09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopy {
  public static void main(String[] args) throws IOException {
    FileInputStream fileInputStream =
            new FileInputStream("c:/000/data.txt");
    FileOutputStream fileOutputStream =
            new FileOutputStream("c:/000/result.txt");

    while (fileInputStream.available() > 0) {
      int data = fileInputStream.read();
      fileOutputStream.write(data);
    }
    byte[] bytes = "\n=End of File=\n".getBytes();
    fileOutputStream.write("\n=End of File=".getBytes());
    fileOutputStream.write("\nHello World!".getBytes());

    fileInputStream.close();
    fileOutputStream.close();
  }
}