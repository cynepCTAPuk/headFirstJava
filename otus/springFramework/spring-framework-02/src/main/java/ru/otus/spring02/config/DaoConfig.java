package ru.otus.spring02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import ru.otus.spring02.dao.PersonDao;
import ru.otus.spring02.dao.PersonDaoSimple;

//@Configuration
@Service
public class DaoConfig {
//    @Bean
    public PersonDao personDao() {
        return new PersonDaoSimple();
    }
}
