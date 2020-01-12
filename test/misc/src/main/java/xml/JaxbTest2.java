package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class JaxbTest2 {
    public static void main(String[] args) throws JAXBException {
        //создание объектов Cat & Zoo для сериализации в XML
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        Zoo zoo = new Zoo();
        zoo.animals.add(cat);
        zoo.animals.add(cat);

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
        Unmarshaller unmarshaller1 = context1.createUnmarshaller();
        Zoo zoo1 = (Zoo) unmarshaller1.unmarshal(reader);
        System.out.println(zoo1);
    }

    @XmlType(name = "zoo")
    @XmlRootElement
    static class Zoo {
        @XmlElementWrapper(name = "wild-animals", nillable = true)
        public List animals = new ArrayList();

        @Override
        public String toString() {
            return "Zoo{" + "animals=" + animals + '}';
        }
    }

    //    @XmlType(name = "tiger")
    static class Cat {
        @XmlElement(name = "tiger")
        public String name;
        @XmlAttribute(name = "age")
        public int age;
        @XmlAttribute(name = "w")
        public int weight;

        Cat() {
        }

        @Override
        public String toString() {
            return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + '}';
        }
    }
}
