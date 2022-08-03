package json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class JsonTest3 {
    public static void main(String[] args) throws IOException {
        //создание объекта для сериализации в JSON
        Cat cat = new Cat();
        cat.name = "Vaska";
        cat.age = 2;
        cat.weight = 4;

        //писать результат сериализации будем в файл
        OutputStream outputStream = new ObjectOutputStream(new FileOutputStream("c:/000/jsonCat.txt"));
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, cat);

        //читаем из файла и создаём новый объект
        InputStream inputStream = new ObjectInputStream(new FileInputStream("c:/000/jsonCat.txt"));
        Cat cat1 = mapper.readValue(inputStream, Cat.class);
        System.out.println(cat1);
    }

    @JsonAutoDetect
    static class Cat {
        public String name;
        public int age;
        public int weight;

        public Cat() {
        }

        @Override
        public String toString() {
            return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + '}';
        }
    }
}
