package ru.otus.jpql;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByName(String name);

//    @Query(value = "SELECT b.name FROM Book AS b WHERE b.author.name = ?1")
    @Query(value = "SELECT b.name FROM Book AS b INNER JOIN b.author a WHERE a.name = ?1")
    List<String> findNamesOfAuthorBooks(String authorName);
}
