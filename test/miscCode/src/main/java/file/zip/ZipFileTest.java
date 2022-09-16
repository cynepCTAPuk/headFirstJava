package file.zip;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipFileTest {
    public static void main(String[] args) {
        try {
            ZipFile zipFile = new ZipFile("C:/000/archive.zip");
            zipFile.stream().forEach(x -> {
                System.out.printf("%20s",x);
                if (!x.isDirectory()) {
                    System.out.printf("%,8d", x.getSize());
                    System.out.printf("%,8d", x.getCompressedSize());
                    System.out.printf("\t%s", new Date(x.getTime()));
                }
                System.out.println();
            });
/*
            Iterator iterator = zipFile.entries().asIterator();
            while (iterator.hasNext()) {
                ZipEntry ze = (ZipEntry) iterator.next();
                String name = ze.getName();
                boolean isDir = ze.isDirectory();
                Date lastModified = new Date(ze.getTime());
                long uncompressedSize = ze.getSize();
                long compressedSize = ze.getCompressedSize();

                System.out.println("\t" + name);
                if (!isDir) {
                    System.out.print("LastModified: " + lastModified);
                    System.out.printf("\tuncompressedSize: %4d", uncompressedSize);
                    System.out.printf("\tcompressedSize: %4d\n", compressedSize);
                }
            }
*/
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
