package xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.*;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class JaxbTest2 {
    public static void main(String[] args) throws JAXBException {
        //создание объектов Cat & Zoo для сериализации в XML
        Cat cat1 = new Cat("Мурка", 5, 4);
        Cat cat2 = new Cat("Барсик", 3, 7);
        Cat cat3 = new Cat("Рыжик", 2, 3);

        Zoo zoo = new Zoo();
        zoo.animals.add(cat1);
        zoo.animals.add(cat2);
        zoo.animals.add(cat3);

        //писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();
        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(Cat.class, Zoo.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // самосериализация
        marshaller.marshal(zoo, writer);
        //преобразовываем все записанное в StringWriter в строку
        String zooString = writer.toString();
        System.out.println(zooString);

        // обратная процедура, создания объекта из XML
        StringReader reader = new StringReader(zooString);
        JAXBContext context1 = JAXBContext.newInstance(Cat.class, Zoo.class);
        Unmarshaller unmarshaller = context1.createUnmarshaller();
        Zoo zoo1 = (Zoo) unmarshaller.unmarshal(reader);
        System.out.println(zoo1);
    }

    @XmlType(name = "zoo")
    @XmlRootElement
    static class Zoo {
        @XmlElementWrapper(name = "wild-animals", nillable = true)
        public List<Cat> animals = new ArrayList<>();

        @Override
        public String toString() {
            return "Zoo{" + "animals=" + animals + '}';
        }
    }

    @XmlType(name = "tiger")
    static class Cat {
        @XmlElement(name = "имя")
        public String name;
        @XmlAttribute(name = "возраст")
        public int age;
        @XmlAttribute(name = "вес")
        public int weight;

        Cat() {
        }

        public Cat(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + '}';
        }
    }
}
