package xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.StringWriter;
import java.security.InvalidParameterException;

public class ToXML {
    public static void main(String[] args) throws JAXBException {
        //создание объекта для сериализации в XML
        Cat cat = new Cat("Murr", 5, 4);

        System.out.println(obj2xml(cat, cat.getClass()));
        System.out.println(getXML(cat));
        printLogAndReturn(cat);
    }

    public static String obj2xml(Object obj, Class<?> clazz) throws JAXBException {

        if (null == obj) throw new InvalidParameterException();
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        return writer.toString();
    }

    public static String getXML(Object obj) throws JAXBException {
        //писать результат сериализации будем в Writer(StringWriter)
        StringWriter writer = new StringWriter();
        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // сама сериализация
        marshaller.marshal(obj, writer);
        //преобразовываем в строку все записанное в StringWriter
        return writer.toString();
    }


    static <T> T printLogAndReturn(Object obj) throws JAXBException {
        // Create a String writer object which will be used to write jaxbElment XML to string
        StringWriter writer = new StringWriter();
        // create JAXBContext which will be used to update writer
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        // marshall or convert jaxbElement containing student to xml format
        context.createMarshaller().marshal(obj, writer);
        // print XML string representation of Student object
        System.out.println(writer.toString());
        return (T) obj;
    }

    @XmlType(name = "cat")
    @XmlRootElement
    static class Cat {
        public String name;
        public int age;
        public int weight;

        public Cat(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        Cat() {
        }
    }
}
