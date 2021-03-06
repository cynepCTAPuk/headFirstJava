package json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class JsonTest4 {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;
        System.out.println(cat);

        OutputStream outputStream = new ObjectOutputStream(new FileOutputStream("c:/000/jsonCat.txt"));
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, cat);

        InputStream inputStream = new ObjectInputStream(new FileInputStream("c:/000/jsonCat.txt"));
        JsonTest3.Cat cat1 = mapper.readValue(inputStream, JsonTest3.Cat.class);
        System.out.println(cat1);

    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    static class Cat {
        private String name; // change name to alias
        private int age;
        private int weight; // don't save value if this field

    public Cat() {
        }

        @Override
        public String toString() {
            return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + '}';
        }
    }
}
