package com.groupj7.homework.service;

import com.groupj7.homework.dto.BookDTO;
import com.groupj7.homework.dto.mapper.BookMapper;
import com.groupj7.homework.model.v1.Book;
import com.groupj7.homework.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    //TODO : what wrong ?
    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }


    public List<Book> list() {
        return bookRepository.findAll();
    }

    public List<BookDTO> filterBooks(String searchStr) {
        return bookRepository.searchBooks(searchStr.toUpperCase())
                .stream().map(bookMapper::bookToDTO).collect(Collectors.toList());
    }
}