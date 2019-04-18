package ru.otus.spring02.dao;

import org.springframework.stereotype.Repository;
import ru.otus.spring02.domain.Person;

@Repository("personDao")
public class PersonDaoSimple implements PersonDao {

    public Person findByName(String name) {
        return new Person(name, 18);
    }
}
