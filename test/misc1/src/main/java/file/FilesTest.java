package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FilesTest {
    public static void main(String[] args) throws IOException {
        //создание файла
        Path testFile1 = Files.createFile(Paths.get("c:/000/testFile111.txt"));
        System.out.println("Был ли файл успешно создан?");
        System.out.println(Files.exists(Paths.get("c:/000/testFile111.txt")));

        //создание директории
        Path testDirectory = Files.createDirectory(Paths.get("c:/000/testDirectory"));
        System.out.println("Была ли директория успешно создана?");
        System.out.println(Files.exists(Paths.get("c:/000/testDirectory")));

        //перемещаем файл в директорию testDirectory. Перемещать надо с указанием имени файла в папке!
        testFile1 = Files.move(testFile1, Paths.get("c:/000/testDirectory/testFile111.txt"), REPLACE_EXISTING);
        System.out.println("Остался ли наш файл в исходной папке?");
        System.out.println(Files.exists(Paths.get("c:/000/testFile111.txt")));
        System.out.println("Был ли наш файл перемещен в testDirectory?");
        System.out.println(Files.exists(Paths.get("c:/000/testDirectory/testFile111.txt")));

        //удаление файла
        Files.delete(testFile1);
        System.out.println("Файл все еще существует?");
        System.out.println(Files.exists(Paths.get("c:/000/testDirectory/testFile111.txt")));
    }
}
