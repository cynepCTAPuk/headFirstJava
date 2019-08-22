package chap05_Inheritance.equals;

import java.util.Objects;

/**
 * This program demonstrates the equals method.
 *
 * @author Cay Horstmann
 * @version 1.12 2012-01-26
 */
public class EqualsTest {
    public static void main(String[] args) {
        var alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        var alice2 = alice1;
        var alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        var bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);

        System.out.println("alice1 == alice2: " + (alice1 == alice2));
        System.out.println("alice1 == alice3: " + (alice1 == alice3));
        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
        System.out.println("alice1.equals(bob): " + alice1.equals(bob));

        System.out.println("bob.toString(): " + bob);

        var carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        var boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        System.out.println("boss.toString(): " + boss);
        System.out.println("carl.equals(boss): " + carl.equals(boss));

        System.out.println("alice1.hashCode(): " + alice1.hashCode());
        System.out.println("alice3.hashCode(): " + alice3.hashCode());
        System.out.println("bob.hashCode(): " + bob.hashCode());

        System.out.println("carl.hashCode(): " + carl.hashCode());
        System.out.println("boss.hashCode(): " + boss.hashCode());

        System.out.printf("CTAPuk: %,d\n", Objects.hash("CTAPuk", "Hi", "!"));
        System.out.printf("CTAPuk: %,d\n", Objects.hash("!", "Hi", "CTAPuk"));
        System.out.printf("%,d\n", Integer.MAX_VALUE);
        System.out.println("Binary: " + 0b1111_1111);
        System.out.println("Octal:  " + 0377);
        System.out.println("Hex:    " + 0xf_f);
    }
}
