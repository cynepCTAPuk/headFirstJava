package annotation.jr.level8lecture09;

import java.util.Arrays;

/**
 * https://javarush.ru/quests/lectures/questcollections.level08.lecture09
 */
public class PersonTest {
    public static void main(String[] args) {
        PersonTest p = new PersonTest();
        System.out.println(p.fight(new Elf().getClass(), new EvilMaster().getClass()));

    }

    public boolean fight(Class first, Class second) {
        if (!first.isAnnotationPresent(Person.class))
            throw new RuntimeException("first param is not game person");
        if (!second.isAnnotationPresent(Person.class))
            throw new RuntimeException("second param is not game person");

        Person firstPerson = (Person) first.getAnnotation(Person.class);
        Person secondPerson = (Person) second.getAnnotation(Person.class);
        Arrays.stream(first.getAnnotations()).forEach(System.out::println);
        Arrays.stream(second.getAnnotations()).forEach(System.out::println);
        System.out.println(firstPerson.name() + " : " + secondPerson.name());

        int firstAttack = firstPerson.attack() * firstPerson.strength() + firstPerson.magic();
        int firstPower = firstPerson.live() * firstPerson.defense() * firstAttack;

        int secondAttack = secondPerson.attack() * secondPerson.strength() + secondPerson.magic();
        int secondPower = secondPerson.live() * secondPerson.defense() * secondAttack;

        System.out.println(firstAttack + " : " + secondAttack);
        return firstPower > secondPower;
    }
}
