package file.zip;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipInputStreamTest {
    public static void main(String[] args) throws IOException {
//        File zipFile = new File("C:/000/zip.zip");
        File zipFile = new File("C:/000/archive.zip");
        String fileSeparator = System.getProperty("file.separator");
        String absoluteZipFilePath = zipFile.getParent();
        File unzipFolder = new File(absoluteZipFilePath + fileSeparator + "unzip");
        if (!unzipFolder.exists()) unzipFolder.mkdir();


        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry entry;
        System.out.printf("%-20s%-8s%-30s\n", "\tFile", "\tSize", "\tDate");
        while ((entry = zis.getNextEntry()) != null) {
            if (!entry.isDirectory()) {
                System.out.printf("%20s", entry);
                System.out.printf("%,8d\t%-30s\n"
                        , entry.getSize()
                        , new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date(entry.getTime()))
                );
            } else
                System.out.printf("%-20s\n", entry);

            File file = new File(absoluteZipFilePath + "/unzip/" + entry.getName());
            if (file.getParent() == null) file.getParentFile().mkdirs();

            FileOutputStream fos = new FileOutputStream(file);
            for (int data = zis.read(); data != -1; data = zis.read()) {
                fos.write(data);
            }
            fos.close();

            zis.closeEntry();
        }
        zis.close();
    }
}