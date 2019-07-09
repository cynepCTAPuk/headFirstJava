import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExTest {
    public static void main(String[] args) {
        int[] drinkPrices = {80, 100, 120};
        System.out.println("Before exception");

/*
        try {
            Files.readAllBytes(Paths.get("fffff"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
*/

        try {
            System.out.println(drinkPrices[20]);
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так...\n" + ex);
        }
        System.out.println("After exception");

    }
}
