package com.example.sf01.service;

import com.example.sf01.dao.PersonDao;
import com.example.sf01.domain.Person;

public class PersonServiceImpl implements PersonService {

    private PersonDao dao;
    public PersonServiceImpl(PersonDao dao) {this.dao = dao;}

    public void setDao(PersonDao dao) {this.dao = dao;}
    public PersonDao getDao() {return dao;}

    public Person getByName(String name) {return dao.findByName(name);}
}