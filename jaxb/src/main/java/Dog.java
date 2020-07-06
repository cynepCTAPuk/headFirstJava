import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "dog")
public class Dog {
    public String name;
    public int age;
    public int weight;
}
