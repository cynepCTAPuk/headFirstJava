package file;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest {
    public static void main(String[] args) throws IOException {
/*
        String url = "https://javarush.ru/testdata/secretPasswords.txt";
        Path passwords = downloadFile(url, Paths.get("c:/000"));
        for (String line : Files.readAllLines(passwords)) System.out.println(line);
*/
        String file = "C:/000/passwords.txt";
        Path filePath = Paths.get(file);
        System.out.println(filePath.isAbsolute());

        Path fileName = filePath.getFileName();
        Path parent = filePath.getParent();
        Path root = filePath.getRoot();
        System.out.println(fileName);
        System.out.println(parent);
        System.out.println(root);

        boolean endWithTxt = filePath.endsWith("000/passwords.txt");
        boolean startsWithLalala = filePath.startsWith("lalalala");
        System.out.println(endWithTxt);
        System.out.println(startsWithLalala);


        Path path5 = Paths.get("C:\\Users\\Java\\.\\examples");
        Path path6 = Paths.get("C:\\Users\\Java\\..\\examples");
        System.out.println(path5.normalize());
        System.out.println(path6.normalize());

        Path testFilePath1 = Paths.get("C:\\Users\\Users\\Users\\Users");
        Path testFilePath2 = Paths.get("C:\\Users\\Users\\Users\\Users\\Username\\Desktop\\testFile.txt");
        System.out.println(testFilePath1.relativize(testFilePath2));
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        String[] strings = url.getFile().split("/");
        Path downloadFile = Paths.get(downloadDirectory.toString(), strings[strings.length - 1]);

        Path tempFile = Files.createTempFile("temp-", ".tmp");
        System.out.println(tempFile.getFileName());

        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        Files.move(tempFile, downloadFile, StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();

        return downloadFile;
    }
}
