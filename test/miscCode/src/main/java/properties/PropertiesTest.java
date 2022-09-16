package properties;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties defaultProp = new Properties();
//        defaultProp.put("zero", "0");

        Properties properties = new Properties(defaultProp);
        properties.put("one", "1");
        properties.put("two", "2");
        properties.put("three", "3");
        properties.put("four", "4");
        System.out.println(properties.get("zero"));
        System.out.println(properties.getProperty("zero","000"));
        properties.store(new FileOutputStream("c:/000/2.properties"),"new comment");
    }
}
