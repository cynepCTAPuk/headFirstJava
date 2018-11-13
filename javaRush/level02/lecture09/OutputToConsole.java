package level02.lecture09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class OutputToConsole {
  public static void main(String[] args) throws IOException {
    FileInputStream input = new FileInputStream("C:/000/result.txt");
    FileChannel channel = input.getChannel();
    byte[] buffer = new byte[256 * 1024];
    ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);

    try {
      for (int length = 0; (length = channel.read(byteBuffer)) != -1;) {
        System.out.write(buffer, 0, length);
        byteBuffer.clear();
      }
    } finally {
      input.close();
    }
  }
}