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
        String file = "C:/000/passwords.txt";
        Path filePath = Paths.get(file);
        System.out.println(filePath.isAbsolute());  // true

        System.out.println(filePath.getFileName()); // passwords.txt
        System.out.println(filePath.getParent());   // C:\000
        System.out.println(filePath.getRoot());     // C:\

        boolean endWithTxt = filePath.endsWith("000/passwords.txt");
        boolean startsWithLalala = filePath.startsWith("lalalala");
        System.out.println(endWithTxt);             // true
        System.out.println(startsWithLalala);       // falsw

        Path path5 = Paths.get("C:\\Users\\Java\\.\\examples");
        Path path6 = Paths.get("C:\\Users\\Java\\..\\examples");
        System.out.println(path5.normalize());      // C:\Users\Java\examples
        System.out.println(path6.normalize());      // C:\Users\examples

        Path testFilePath1 = Paths.get("C:\\Users\\Users\\Users\\Users");
        Path testFilePath2 = Paths.get("C:\\Users\\Users\\Users\\Users\\Username\\Desktop\\testFile.txt");
        System.out.println("relativize: " + testFilePath1.relativize(testFilePath2));

        Path path = Paths.get("\\");
        System.out.println(Paths.get("c:/0/").relativize(Paths.get("c:/000/2")));
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
