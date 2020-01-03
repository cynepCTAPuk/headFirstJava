package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutPutStreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File("c:/000/berns.txt");

        FileOutputStream fos = new FileOutputStream("c:/000/archive.zip");  //создаем архив
        ZipOutputStream zos = new ZipOutputStream(fos);
        zos.setLevel(1); // 0-9
        ZipEntry entry = new ZipEntry("document.txt");
        zos.putNextEntry(entry);            //кладем в архив zip «архивный объект» ZipEntry
        Files.copy(file.toPath(), zos);     //копируем файл «berns.txt» в архив под именем «document.txt»
        zos.close();                        //закрываем архив
    }
}
