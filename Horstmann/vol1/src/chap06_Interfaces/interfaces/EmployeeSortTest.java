package chap06_Interfaces.interfaces;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

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

       Path path = Paths.get("jdk", "jre", "bin");
       System.out.println(path);
       path = Path.of("c:", "V", "java");
       System.out.println(path);
    }
}
