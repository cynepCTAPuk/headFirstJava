package json.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(one);
//        mapper.disable(MapperFeature.USE_ANNOTATIONS);
//        System.out.println(mapper.writeValueAsString(one));
        String json = mapper.disable(MapperFeature.USE_ANNOTATIONS).writeValueAsString(one);
/*
        String resultString = writer.toString().replaceFirst(
                one.getClass().getSimpleName().toLowerCase(), resultClassObject.getSimpleName().toLowerCase());
*/
        Object ob = mapper.readValue(json, resultClassObject);
        System.out.println(ob);
        return ob;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First {
        public int i;
        public String name;

        @Override
        public String toString() {
            return "First{" + "i=" + i + ", name='" + name + '\'' + '}';
        }
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second {
        public int i;
        public String name;

        @Override
        public String toString() {
            return "Second{" + "i=" + i + ", name='" + name + '\'' + '}';
        }
    }
}
