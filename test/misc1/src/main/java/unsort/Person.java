package unsort;

public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "unsort.Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
