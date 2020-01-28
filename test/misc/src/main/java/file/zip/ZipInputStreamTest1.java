package file.zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipInputStreamTest1 {
    public static void main(String args[]) throws Exception {
/*
        if (args.length != 2) {
            System.err.println("zipreader zipfile outputdir");
            return;
        }
        String zipFile = args[0];
        String unzipDir = args[1];
*/

        String zipFile = "c:/000/archive.zip";
        String unzipDir = "c:/000/unzip";
        String format = "Entry: %s\tlen: %,8d\tadded: %TD\n";

        byte[] buffer = new byte[1024];
        InputStream fis = new FileInputStream(zipFile);
        ZipInputStream zis = new ZipInputStream(fis);

        try {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                System.out.printf(format, entry.getName(), entry.getSize(), new Date(entry.getTime()));
                String unzipFile = unzipDir + "/" + entry.getName();
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(unzipFile);
                    int len = 0;
                    while ((len = zis.read(buffer)) > 0) fos.write(buffer, 0, len);
                } finally {
                    if (fos != null) fos.close();
                }
            }
        } finally {
            zis.close();
            fis.close();
        }
    }
}