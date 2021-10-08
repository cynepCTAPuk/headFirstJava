package nativ;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String firstName, lastName;
    private int age;

    public static void main(String[] args) {
        Person person = new Person("Ivan", "Ivanovich", 44);
        System.out.println(person);
    }
}
