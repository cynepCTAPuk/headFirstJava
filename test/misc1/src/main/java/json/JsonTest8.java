package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class JsonTest8 {
    public static void main(String[] args) throws IOException {
        String jsonString = "{\"name\":\"Murka\",\"cats\":[{\"name\":\"Timka\"},{\"name\":\"Killer\"}]}";
        System.out.println(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        Cat cat = mapper.readValue(jsonString, Cat.class);
        System.out.println(cat);
        System.out.println(cat.cats.getClass());
    }

    static class Cat {
        public String name;
        @JsonDeserialize(as= LinkedList.class)
        public List<Cat> cats;

        public Cat() {
        }

        @Override
        public String toString() {
            return "Cat{" + "name='" + name + '\'' + ", cats=" + cats + '}';
        }
    }
}
