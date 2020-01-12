package json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JsonTest9 {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, pets);
        System.out.println(writer.toString());
    }

    @JsonAutoDetect
    static class Pet {
        public String name;
    }

    @JsonAutoDetect
    static class Cat extends Pet {
        public int age;
    }

    @JsonAutoDetect
    static class Dog extends Pet {
        public int age;
        public String owner;
    }
}
