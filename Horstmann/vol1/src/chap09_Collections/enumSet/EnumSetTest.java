package chap09_Collections.enumSet;

import java.util.EnumMap;
import java.util.EnumSet;

public class EnumSetTest {
    enum Weekday {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

    public static void main(String[] args) {
        EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
        EnumSet<Weekday> never = EnumSet.noneOf(Weekday.class);
        EnumSet<Weekday> workday = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
        EnumSet<Weekday> mwf = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        EnumSet<Weekday> weekend = EnumSet.range(Weekday.SATURDAY, Weekday.SUNDAY);

        System.out.println(always);
        System.out.println(never);
        System.out.println(workday);
        System.out.println(mwf);
        System.out.println(weekend);

        var personInCharge = new EnumMap<Weekday, Employee>(Weekday.class);
        personInCharge.put(Weekday.MONDAY, new Employee("Ivan"));
        personInCharge.put(Weekday.TUESDAY, new Employee("Vladimir"));
        
        System.out.println(personInCharge);
    }
}
