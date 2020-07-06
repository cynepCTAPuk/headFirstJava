package zoo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "tiger")
public class Cat implements Animal{
    @XmlElement(name = "catname")
    public String name;
    @XmlAttribute(name = "возраст")
    public int age;
    @XmlAttribute(name = "вес")
    public int weight;

}
