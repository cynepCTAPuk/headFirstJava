package chap05_Inheritance.resources;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Cay Horstmann
 * @version 1.5 2018-03-15
 */
public class CopyResourceTest {
    public static void main(String[] args) throws IOException {
        Class cl = CopyResourceTest.class;

        InputStream stream = cl.getResourceAsStream(
                "/chap05_Inheritance/resources/data/about.txt");
        var txt = new String(stream.readAllBytes());
        stream.close();

        System.out.println(txt);
    }
}
