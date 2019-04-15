package com.example.springbootrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootrest.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}