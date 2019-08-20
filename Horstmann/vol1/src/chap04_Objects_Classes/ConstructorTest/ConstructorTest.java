package chap04_Objects_Classes.ConstructorTest;

/**
 * This program demonstrates object construction.
 *
 * @author Cay Horstmann
 * @version 1.02 2018-04-10
 */
public class ConstructorTest {
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        var staff = new Employee[3];

        staff[0] = new Employee("Harry", 40_000);
        staff[1] = new Employee(60_000);
        staff[2] = new Employee();

        // print out information about all Employee objects
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + "," +
                    "id=" + e.getId() + ",salary=" + e.getSalary());
    }
}

