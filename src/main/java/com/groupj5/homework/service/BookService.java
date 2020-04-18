package com.groupj5.homework.service;

import com.groupj5.homework.model.v1.Book;
import com.groupj5.homework.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    //TODO : what wrong ?
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> list() {
        return bookRepository.findAll();
    }
}