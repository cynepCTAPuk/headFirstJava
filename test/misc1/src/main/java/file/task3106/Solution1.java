package file.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution1 {
    public static void main(String[] args) throws IOException {
        List<FileInputStream> list = new ArrayList<>(args.length );
        for (int i = 0; i < args.length; i++) list.add(new FileInputStream(args[i]));
//        FileOutputStream fos = new FileOutputStream("c:/000/123.txt", true);

//        ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(Arrays.asList(new FileInputStream("c:/000/1.zip"), new FileInputStream("c:/000/3.zip"), new FileInputStream("c:/000/2.zip")))));
        ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(list)));
        System.out.println(zis.available());
        try {
            for (ZipEntry entry = null; (entry = zis.getNextEntry()) != null; ) {
                System.out.println(entry.getName());
                OutputStream os = new BufferedOutputStream(new FileOutputStream(entry.getName()));
                try {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for (int readBytes = -1; (readBytes = zis.read(buffer, 0, bufferSize)) > -1; ) {
                        os.write(buffer, 0, readBytes);
//                        fos.write(buffer, 0, readBytes);
                    }
                    os.flush();
                } finally {
                    os.close();
                }
            }
        } finally {
            zis.close();
//        fos.close();
        }
    }
}