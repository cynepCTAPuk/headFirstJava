package com.example.sf01.service;

import com.example.sf01.domain.Person;

public interface PersonService {

    Person getByName(String name);
}