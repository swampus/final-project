package com.groupj5.homework.repository;

import com.groupj5.homework.model.v1.Book;
import com.groupj5.homework.model.v1.BookContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookContentRepository extends JpaRepository<Book, Long> {

    @Query("Select bc from BookContent bc where bookId = ?1 AND pageNum = ?1")
    BookContent searchBooksContent(@Param("bookId") Long bookId, @Param("pageNum") Long pageNum);

}

