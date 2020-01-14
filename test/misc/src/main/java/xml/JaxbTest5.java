package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JaxbTest5 {
    public static void main(String[] args) throws JAXBException {
        //создание объекта для сериализации в XML
        Shop shop = new Shop();
        Goods goods = new Goods();
        goods.names.add("S1");
        goods.names.add("S2");
        goods.names.add("S3");
        shop.goods = goods;
        shop.count = 12;
        shop.profit = 123.4;
        shop.secretData = new String[]{"String1", "String2", "String3"};

        //писать результат сериализации будем в Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(Shop.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // сама сериализация
        marshaller.marshal(shop, writer);

        //преобразовываем в строку все записанное в StringWriter
        String result = writer.toString();
        System.out.println(result);

        // обратная процедура, создания объекта из XML
        StringReader reader = new StringReader(result);
        JAXBContext context1 = JAXBContext.newInstance(Shop.class, Goods.class);
        Unmarshaller unmarshaller1 = context1.createUnmarshaller();
        Shop shop1 = (Shop) unmarshaller1.unmarshal(reader);
        System.out.println(shop1);
    }

    @XmlType(name = "shop")
    @XmlRootElement
    static class Shop {
        public Goods goods;
        public int count;
        public double profit;
        public String[] secretData;

        Shop() {
        }

        @Override
        public String toString() {
            return "Shop{" + "goods=" + goods + ", count=" + count +
                    ", profit=" + profit + ", secretData=" + Arrays.toString(secretData) + '}';
        }
    }

    static class Goods {
        public List<String> names = new ArrayList<>();

        @Override
        public String toString() {
            return "Goods{" + "names=" + names + '}';
        }
    }
}
