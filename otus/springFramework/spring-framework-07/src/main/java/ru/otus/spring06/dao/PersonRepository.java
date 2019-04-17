package ru.otus.spring06.dao;

import ru.otus.spring06.domain.Person;

public interface PersonRepository {

    Person getById(int id);
}
