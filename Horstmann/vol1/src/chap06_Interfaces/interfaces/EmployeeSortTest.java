package chap06_Interfaces.interfaces;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

/**
 * This program demonstrates the use of the Comparable interface.
 *
 * @author Cay Horstmann
 * @version 1.30 2004-02-27
 */
public class EmployeeSortTest {
    public static void main(String[] args) {
        var staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);

        Arrays.sort(staff);
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());

        System.out.println();
        Arrays.sort(staff, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());

        System.out.println();
        Path path = Paths.get("jdk", "jre", "bin");
        System.out.println("Paths.get: " + path);
        path = Path.of("c:", "V", "java");
        System.out.println("Path.of:   " + path);

        System.out.println();
        Arrays.sort(staff, Comparator.comparing(Employee::getSalary));
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());

    }
}
