package com.example.sf01.dao;

import com.example.sf01.domain.Person;

public interface PersonDao {

    Person findByName(String name);
}