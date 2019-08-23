package chap05_Inheritance.resources;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @version 1.5 2018-03-15
 * @author Cay Horstmann
 */
public class ResourceTest
{
   public static void main(String[] args) throws IOException
   {
      Class cl = ResourceTest.class;
      URL aboutURL = cl.getResource("/chap05_Inheritance/resources/about.gif");
      var icon = new ImageIcon(aboutURL);

      InputStream stream = cl.getResourceAsStream("/chap05_Inheritance/resources/data/about.txt");
      var about = new String(stream.readAllBytes(), "UTF-8");

      InputStream stream2 = cl.getResourceAsStream("/chap05_Inheritance/corejava/title.txt");
      var title = new String(stream2.readAllBytes(), StandardCharsets.UTF_8).trim();

      JOptionPane.showMessageDialog(null, about, title,
              JOptionPane.INFORMATION_MESSAGE, icon);
   }
}
