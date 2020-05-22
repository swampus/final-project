package com.groupj7.homework.repository;

import com.groupj7.homework.model.v1.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("Select b from Book b where UPPER(b.name) LIKE  %?1% "
            + " OR UPPER(b.author) LIKE %?1% OR UPPER(b.annotation) LIKE %?1%")
    List<Book> searchBooks(String name);
}
