package chap04_Objects_Classes.StaticTest;

/**
 * This program demonstrates static methods.
 *
 * @author Cay Horstmann
 * @version 1.02 2008-04-10
 */
public class StaticTest {
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        var staff = new Employee[3];

        staff[0] = new Employee("Tom", 40_000);
        staff[1] = new Employee("Dick", 60_000);
        staff[2] = new Employee("Harry", 65_000);

        // print out information about all Employee objects
        for (Employee e : staff) {
            e.setId();
            System.out.println("name=" + e.getName() + "," +
                    "id=" + e.getId() + "," +
                    "salary=" + e.getSalary());
        }

        int n = Employee.getNextId(); // calls static method
        System.out.println("Next available id=" + n);
    }
}

