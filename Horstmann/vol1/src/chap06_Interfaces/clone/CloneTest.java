package chap06_Interfaces.clone;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * This program demonstrates cloning.
 *
 * @author Cay Horstmann
 * @version 1.11 2018-03-16
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        var original = new Employee("John Q. Public", 50000);
        var clone = original.clone();
        original.setHireDay(2000, 1, 1);

        Employee copy = original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2002, 12, 31);

        System.out.println("original=" + original);
        System.out.println("copy    =" + copy);

        Class cl = clone.getClass();
        System.out.println("clone   =" + clone);

        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getSimpleName() + " " + name + ";");
        }
    }
}
