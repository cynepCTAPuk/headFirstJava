package json;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class JsonTest6 {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;
        cat.json = "{\"attr\":false}";
        System.out.println(cat);

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(cat);
        System.out.println(result);
        FileWriter writer = new FileWriter("c:/000/jsonCat.txt");
        writer.write(result);
        writer.close();

        FileReader reader = new FileReader("c:/000/jsonCat.txt");
        Cat cat1 = new ObjectMapper().readValue(reader, Cat.class);
        System.out.println(cat1);
    }

    @JsonPropertyOrder({"name", "weight", "age"})
//    @JsonIgnoreProperties({"age"})
    static class Cat {
        private String name;
        private int age;
        //        @JsonIgnore
        private int weight; // don't save value if this field
        public String json;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getWeight() {
            return weight;
        }

        public Cat() {
        }

        @Override
        public String toString() {
            return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + ", json='" + json + '\'' + '}';
        }
    }
}
