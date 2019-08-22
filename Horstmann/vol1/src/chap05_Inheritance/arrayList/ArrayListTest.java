package chap05_Inheritance.arrayList;

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;

/**
 * This program demonstrates the ArrayList class.
 *
 * @author Cay Horstmann
 * @version 1.11 2012-01-26
 */
public class ArrayListTest {
    public static void main(String[] args) {
        // fill the staff array list with three Employee objects
        var staff = new ArrayList<Employee>();
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));
        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        {
            var backup = new Employee[staff.size()];
            staff.toArray(backup);
            for (Employee e : backup)
                System.out.printf("%-13s - %,9.1f\n", e.getName(), e.getSalary());
        }
        System.out.println("Sort");
//        staff.sort(Comparator.comparing(Employee::getName));
//        staff.sort((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()));
//        staff.sort((o1, o2) -> o2.getHireDay().compareTo(o1.getHireDay()));
        staff.sort(ArrayListTest::compare);
        // raise everyone's salary by 5%
        for (Employee e : staff) e.raiseSalary(5);
        // print out information about all Employee objects
        print(staff);

        System.out.println("Remove: " + staff.remove(0).getName());
        print(staff);

        Integer a = 999;
        Integer b = 999;
        System.out.println(a == b); // false
        String c = "hello";
        String d = "hello";
        System.out.println(c == d); // true
        System.out.println(c.compareTo(d)); // 0
        System.out.println(new String("hello") == "hello"); // false
        System.out.println(new String("hello").compareTo("hello")); // 0
        for (int i = 128; i < 256; i++) {
            Character ch = (char) i;
            System.out.print(" " + i + ":" + ch);
        }
    }

    private static void print(ArrayList<Employee> staff) {
        for (Employee e : staff)
            System.out.println(
                    "name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
    }

    private static int compare(Employee o1, Employee o2) {
        return o2.getHireDay().compareTo(o1.getHireDay());
    }
}
