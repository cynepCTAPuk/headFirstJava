import java.io.BufferedReader;
import java.io.FileReader;

public class ReadAndPrintFile {
    public static void main(String[] args) {
        read("src/ReadAndPrintFile.java");
    }

    private static void read(String file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String string;
            while ((string = reader.readLine()) != null) stringBuilder.append(string).append("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder);
    }
}
