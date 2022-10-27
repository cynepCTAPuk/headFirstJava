package lombock;

public class PersonTest {
    public record PersonR(String name, String surname, Integer age, Integer weight) {
    }

    public static void main(String[] args) {
        PersonR record = new PersonR("Ivan", "Record", 33, 100);
        System.out.println(record);

        PersonL lombock = new PersonL("Ivan", "Lombock", 33);
        System.out.println(lombock);
    }
}
