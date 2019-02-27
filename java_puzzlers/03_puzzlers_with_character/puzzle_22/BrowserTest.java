import java.awt.*;
import java.io.*;
import java.net.*;

public class BrowserTest {
    public static void main(String[] args) throws URISyntaxException, IOException {
        System.out.print("iexplore:");
        String url_1 = "http://www.example.com";
        String url_2 = "http://www.google.com";
        System.out.println(":maximize");

/*
        if (Desktop.isDesktopSupported() && Desktop.getDesktop()
                .isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI(url_1));
        }
*/

/*
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url_2));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url_2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
*/

/*
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create("chrome"));
*/
    }
}
