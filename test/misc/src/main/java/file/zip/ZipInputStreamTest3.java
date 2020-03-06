package file.zip;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipInputStreamTest3 {
    public static void main(String[] args) throws Exception {
        String zipFile = "c:/000/archive.zip";
        String unzipDir = "c:/000/unzip";
        if (Files.notExists(Paths.get(unzipDir))) Files.createDirectory(Paths.get(unzipDir));
        String format =
                "name: %s\n" +
                        "\tsize: %d\n" +
                        "\tcompressed size: %d\n" +
                        "\tmethod: %d\n" +
                        "\tadded: %TD\n";

        byte[] buffer = new byte[2048];

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile))) {

            while (true) {
                ZipEntry entry = zipInputStream.getNextEntry();
                if (entry == null) break;
                String unzipFile = unzipDir + File.separator + entry.getName();
                OutputStream fileOutputStream = new FileOutputStream(unzipFile);
                int len = 0;
                while ((len = zipInputStream.read(buffer)) > 0)
                    fileOutputStream.write(buffer, 0, len);

                System.out.printf(format,
                        entry.getName(),
                        entry.getSize(),
                        entry.getCompressedSize(),
                        entry.getMethod(),
                        new Date(entry.getTime()));

                fileOutputStream.close();
                zipInputStream.closeEntry();
            }
        }
    }
}