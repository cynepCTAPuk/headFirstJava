import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortText {
    public static void main(String[] args) {
        String unsortedText = "C:/000/tam.txt";
        String sortedText;
        File file = new File(unsortedText);

        try (InputStream fileInputStream = new FileInputStream(file)) {


        } catch (Exception ex) {
        }
    }
}
