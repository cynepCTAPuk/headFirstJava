import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "", name = "cat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cat {
    private String name;
    private int age;
    private int weight;

    public Cat() {
    }

    public Cat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "zoo.Cat{" +
                       "name='" + name + '\'' +
                       ", age=" + age +
                       ", weight=" + weight +
                       '}';
    }
}
