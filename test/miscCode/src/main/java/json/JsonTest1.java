package json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;

public class JsonTest1 {
    public static void main(String[] args) throws IOException {
        String jsonString = "{\"name\":\"Barsik\",\"age\":3,\"weight\":5}";
        StringReader reader = new StringReader(jsonString);
        System.out.println(jsonString);

        ObjectMapper mapper = new ObjectMapper();
        Cat cat = mapper.readValue(reader, Cat.class);
        System.out.println(cat);
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
