package xml;

import xml.task3307.Solution;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JaxbTest4 {
    public static void main(String[] args) throws JAXBException, IOException {
        Code code = Code.START;
        String codeString = enumToXML(code);
        System.out.println(codeString);

        String codeString1 = codeString;

        System.out.println(xmlToObj(codeString,Code.class));
    }
    public static <T> T xmlToObj(String xmlData, Class<T> clazz) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (T) unmarshaller.unmarshal(new StringReader(xmlData));
    }
    public static String enumToXML(Code code) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Code.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(code, writer);
        return writer.toString();
    }

    @XmlType
    @XmlEnum(Integer.class)
    @XmlRootElement
    enum Code {
        @XmlEnumValue ("1") START,
        @XmlEnumValue ("2") INPROGRESS,
        @XmlEnumValue ("3") FINISH,
        @XmlEnumValue ("-1") ERROR
    }

    @XmlType
    @XmlEnum(String.class)
    enum Card {
        @XmlEnumValue("Пика") CLUBS,
        @XmlEnumValue("Бубна") DIAMONDS,
        @XmlEnumValue("Черва") HEARTS,
        @XmlEnumValue("Трефа") SPADES
    }
}
