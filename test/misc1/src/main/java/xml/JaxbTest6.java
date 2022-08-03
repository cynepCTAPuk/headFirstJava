package xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class JaxbTest6 {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty("com.sun.xml.bind.xmlHeaders", "<!--" + comment + "-->\n"); // add comment
//        marshaller.setProperty("<" + tagName + ">", "<!--" + comment + "-->\n");
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true); // no header <?xml version

        marshaller.marshal(obj, writer);
//        marshaller.marshal(obj, System.out);
        String xml = writer.toString();
        String newXml = xml.replaceAll("<" + tagName , "<!--" + comment + "-->\n<" + tagName);

        return newXml;
    }

    public static void main(String[] args) throws JAXBException {
        Pets pets = new Pets();
        pets.cats.add(new Cat("Barsik", 1, 2));
        pets.cats.add(new Cat("Marsik", 2, 3));

        Cat cat = new Cat("Barsik", 1, 2);
        System.out.println(toXmlWithComment(pets, "cats", "comment"));
//        toXmlWithComment(pets, "cats", "comment");
    }

    @XmlType(name = "pets")
    @XmlRootElement
    static class Pets {
        public List<Cat> cats = new ArrayList<>();
    }

    @XmlType(name = "cat")
    @XmlRootElement
    static class Cat {
        public String name;
        public int age;
        public int weight;

        Cat() {
        }

        public Cat(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
    }
}
