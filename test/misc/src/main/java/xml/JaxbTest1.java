package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * JAXB-аннотации	Описание
 * @XmlElement(name)
 * Ставится около поля. Поле будет представлено в XML-элементом. Позволяет задать имя для тэга.
 * @XmlAttribute(name)
 * Ставится около поля. Поле будет представлено в XML-атрибутом! Позволяет задать имя для атрибута.
 * @XmlElementWrapper(nillable = true)
 * Ставится около поля. Позволяет задать «обрамляющий тег» для группы элементов.
 * @XmlType
 * Ставится около класса. Позволяет задать метод для создания объекта, если конструктор по умолчанию private.
 * @XmlJavaTypeAdapter
 * Ставится около поля.Позволяет задать класс, который будет преобразовывать данные поля в строку.
 */
public class JaxbTest1 {
    public static void main(String[] args) throws JAXBException {
        String xmldata = "<cat><name>Murka</name><age>5</age><weight>4</weight></cat>";
        StringReader reader = new StringReader(xmldata);

        JAXBContext context = JAXBContext.newInstance(Cat.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Cat cat = (Cat) unmarshaller.unmarshal(reader);
        System.out.println(cat);
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
}
