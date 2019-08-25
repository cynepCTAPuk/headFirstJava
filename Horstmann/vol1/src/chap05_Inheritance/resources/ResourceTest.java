package chap05_Inheritance.resources;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Cay Horstmann
 * @version 1.5 2018-03-15
 */
public class ResourceTest {
    public static void main(String[] args) throws IOException {
        String path = "/chap05_Inheritance/";
        Class cl = ResourceTest.class;

        URL aboutGIF = cl.getResource(path + "resources/about.gif");
        var icon = new ImageIcon(aboutGIF);

        InputStream stream = cl.getResourceAsStream(path + "resources/data/about.txt");
        var aboutTXT = new String(stream.readAllBytes(), "UTF-8");
        System.out.println(aboutTXT);

        InputStream stream2 = cl.getResourceAsStream(path + "corejava/title.txt");
        var title = new String(stream2.readAllBytes(), StandardCharsets.UTF_8).trim();

        JOptionPane.showMessageDialog(
                null, aboutTXT, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
