package chap05_Inheritance.objectAnalyzer;

import chap05_Inheritance.inheritance.Employee;

import java.lang.reflect.Field;

public class AnalyzeObjectRuntime {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        var harry = new Employee("Harry Hacker", 50_000, 1988, 10, 1);
        Class cl = harry.getClass();

        Field name = cl.getDeclaredField("name");
        Field salary = cl.getDeclaredField("salary");

        name.setAccessible(true);
        salary.setAccessible(true);

        Object v1 = name.get(harry);
        Object v2 = salary.get(harry);
        salary.set(harry,29_999);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(harry.getSalary());
    }
}
