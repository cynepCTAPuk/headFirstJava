package ru.otus.spring06.dao;

import org.springframework.stereotype.Repository;
import ru.otus.spring06.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonRepositoryJdbc implements PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Person getById(int id) {
        return em.find(Person.class, id);
    }
}
