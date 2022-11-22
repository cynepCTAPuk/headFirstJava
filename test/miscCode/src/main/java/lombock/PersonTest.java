package lombock;

public class PersonTest {
    public record PersonRecord(String name, String surname, Integer age, Integer weight) {
    }

    public static void main(String[] args) {
        PersonRecord record = new PersonRecord("Ivan", "Record", 33, 100);
        System.out.println(record);

        PersonLombok lombock = new PersonLombok("Ivan", "Lombock", 33);
        System.out.println(lombock);
    }
}
