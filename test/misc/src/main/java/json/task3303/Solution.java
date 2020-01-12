package json.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName), clazz);
    }

    public static void main(String[] args) throws IOException {
        Cat cat = convertFromJsonToNormal("c:/000/jsonCat.txt", Cat.class);
        System.out.println(cat);
    }
    static class Cat {
        public String name;
        public int age;
        public int weight;

        @Override
        public String toString() {
            return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + '}';
        }
    }
}
