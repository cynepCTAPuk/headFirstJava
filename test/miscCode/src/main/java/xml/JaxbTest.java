package xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

import java.io.StringWriter;
import java.io.Writer;

public class JaxbTest {
    public static void main(String[] args) throws JAXBException {
        //создание объекта для сериализации в XML
        Cat cat = new Cat();
        cat.setName("Murka");
        cat.setAge(5);
        cat.setWeight(4);

        //писать результат сериализации будем в Writer(StringWriter)
        Writer writer = new StringWriter();

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
    @Getter
    @Setter static class Cat {
        private String name;
        private int age;
        private int weight;
    }
}
