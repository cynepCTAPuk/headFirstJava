//: io/FileLocking.java
package chap18_io;
import java.nio.channels.*;
import java.util.concurrent.*;
import java.io.*;
public class FileLocking {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos= new FileOutputStream("c:/000/file.txt");
        FileLock fl = fos.getChannel().tryLock();
        if(fl != null) {
            System.out.println("Locked File \t" + System.currentTimeMillis());
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            System.out.println("Released Lock \t" + System.currentTimeMillis());
        }
        fos.close();
    }
} /* Output:
Locked File
Released Lock
*///:~