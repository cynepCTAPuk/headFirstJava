package chap05_Inheritance.arrayList;

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
        var staff = new ArrayList<Employee>(5);
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));
        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
//        staff.sort(Comparator.comparing(Employee::getName));
//        staff.sort((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()));
//        staff.sort((o1, o2) -> o2.getHireDay().compareTo(o1.getHireDay()));
        {
            var backup = new Employee[staff.size()];
            staff.toArray(backup);
            for (Employee e : backup)
                System.out.printf("%-13s - %,9.1f\n", e.getName(), e.getSalary());
        }
        staff.sort(ArrayListTest::compare);
        // raise everyone's salary by 5%
        for (Employee e : staff) e.raiseSalary(5);
        // print out information about all Employee objects
        print(staff);
        staff.remove(0);
        print(staff);
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
