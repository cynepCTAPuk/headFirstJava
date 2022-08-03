package in_out;

import java.io.FileWriter;
import java.io.IOException;

public class WriteAFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("src/Foo.txt");
            writer.write("Hello foo!");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
