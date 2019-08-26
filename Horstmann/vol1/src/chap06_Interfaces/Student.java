package chap06_Interfaces;

public class Student implements Person, Named {
    @Override
    public String getName() {
        return Named.super.getName();
    }

    public static void main(String[] args) {
        System.out.println(new Student().getName());
    }
}

interface Person {
    default String getName() {
        return "";
    }
}

interface Named {
    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
}