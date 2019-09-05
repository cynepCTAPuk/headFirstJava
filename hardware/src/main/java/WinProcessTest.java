import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WinProcessTest {
    public static void main(String[] args) {
        try {
//            Process p = Runtime.getRuntime().exec("ps -e"); // Linux
//            String tasklist = "tasklist.exe /fo csv /nh"; // Windows csv format, no header
            String tasklist = "tasklist.exe"; // Windows
// Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + tasklist);
            Process p = Runtime.getRuntime().exec(tasklist);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line); //<-- Parse data here.
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
