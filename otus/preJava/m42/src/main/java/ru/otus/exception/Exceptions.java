package ru.otus.exception;

public class Exceptions {
    class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private Person getPerson() {
        Person p = new Person("Ivan");
        return p;
    }

    private Person getPerson2() {
        Person p = null;
        return p;
    }

    private void print(Person p) {
        System.out.println(p.toString());
    }

    class PersonNotFoundException extends Exception {

    }

    private void processPerson(Person p) throws PersonNotFoundException {
        if (p == null) throw new PersonNotFoundException();
    }

    private void doProcessing() throws PersonNotFoundException {
        Person p = getPerson2();
        processPerson(p);
    }

    public static void main(String[] args)  {
        Exceptions e = new Exceptions();
        e.print(e.getPerson());
//        e.print(e.getPerson2());
        try {
            e.doProcessing();
        } catch (PersonNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
