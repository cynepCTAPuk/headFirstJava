package ru.otus.spring01.dao;

import ru.otus.spring01.domain.Person;

public class PersonDaoSimple implements PersonDao {
    int age = 18;

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public Person findByName(String name) {return new Person(name, age);}
}