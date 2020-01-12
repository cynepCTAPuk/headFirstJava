package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringWriter;

public class JaxbTest {
    public static void main(String[] args) throws JAXBException {
        //создание объекта для сериализации в XML
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        //писать результат сериализации будем в Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(Cat.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // сама сериализация
        marshaller.marshal(cat, writer);

        //преобразовываем в строку все записанное в StringWriter
        String result = writer.toString();
        System.out.println(result);
    }

    @XmlType(name = "cat")
    @XmlRootElement
    static class Cat {
        public String name;
        public int age;
        public int weight;

        Cat() {
        }
    }
}
