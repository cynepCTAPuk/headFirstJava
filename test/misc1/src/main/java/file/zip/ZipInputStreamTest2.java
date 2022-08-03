package file.zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipInputStreamTest2 {
    public static void main(String[] args) throws Exception {
        String zipFile = "c:/000/archive.zip";
        String unzipDir = "c:/000/unzip";
        String format = "Entry: %s\tlen: %,8d\tadded: %TD\n";

        InputStream fis = new FileInputStream(zipFile);
        ZipInputStream zis = new ZipInputStream(fis);
        while (true) {
            ZipEntry entry = zis.getNextEntry();
            if (entry == null) break;
            System.out.printf(format, entry.getName(), entry.getSize(), new Date(entry.getTime()));
            String unzipFile = unzipDir + "/" + entry.getName();
            Files.copy(zis, Paths.get(unzipFile), StandardCopyOption.REPLACE_EXISTING);
            zis.closeEntry();
        }
        zis.close();
        fis.close();
    }
}