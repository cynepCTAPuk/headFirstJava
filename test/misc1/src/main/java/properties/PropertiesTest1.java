package properties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest1 {
    public static void main(String[] args) throws IOException {
        //файл, который хранит свойства нашего проекта
        File file = new File("c:/000/2.properties");

        //создаем объект Properties и загружаем в него данные из файла.
        Properties properties = new Properties();
        properties.load(new FileReader(file));

        //получаем значения свойств из объекта Properties
        String email = properties.getProperty("email");
        String directory = properties.getProperty("directory");

        //получаем числовое значение из объекта Properties
        int maxFileSize = Integer.parseInt(properties.getProperty("max.size", "10000"));
        System.out.println(maxFileSize);

        //проходимся по всем ключам и печатаем все их значения на консоль
        for (String key : properties.stringPropertyNames()) {
            System.out.println(properties.get(key));
        }
    }
}
