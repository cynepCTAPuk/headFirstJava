package xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.StringReader;
import java.util.List;

public class JaxbTest3 {
    public static void main(String[] args) throws JAXBException {
        String xmldata = "<zoo><cat/><cat/><dog/><cat/></zoo>";
        StringReader reader = new StringReader(xmldata);

        JAXBContext context = JAXBContext.newInstance(Cat.class, Zoo.class, Dog.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Zoo zoo = (Zoo) unmarshaller.unmarshal(reader);
        System.out.println(zoo.animals.getClass());
        System.out.println(zoo);
    }

    @XmlType(name = "zoo")
    @XmlRootElement
    static class Zoo {
        @XmlAnyElement // @XmlAny probably for older versions
        public List<Object> animals;

        @Override
        public String toString() {
            return "Zoo{" + "animals=" + animals + '}';
        }
    }

    @XmlType(name = "cat")
    @XmlRootElement
    static class Cat {
        public String name;
        public int age;
        public int weight;

        Cat() {
        }

        @Override
        public String toString() {
            return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + '}';
        }
    }

    @XmlType(name = "dog")
    @XmlRootElement
    static class Dog {
        public String name;
        public int age;
        public int weight;

        Dog() {
        }

        @Override
        public String toString() {
            return "Dog{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + '}';
        }
    }
}
