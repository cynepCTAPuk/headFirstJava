package ru.otus.spring01.dao;

import ru.otus.spring01.domain.Person;

public class PersonDaoSimple implements PersonDao {
    int age = 22;
//    private int defaultAge;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person findByName(String name) {
        return new Person(name, age);
    }

    public void setDefaultAge(int defaultAge) {
        age = 77;
    }

    public int getDefaultAge() {
        return age;
    }
}