package com.groupj7.homework.controller.v1;

import com.groupj7.homework.dto.BookDTO;
import com.groupj7.homework.dto.mapper.BookMapper;
import com.groupj7.homework.model.v1.Book;
import com.groupj7.homework.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/rest/Book.svc")
public class BookController {

    private BookMapper bookMapper;

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService,
                          BookMapper bookMapper) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @GetMapping(value = "/books")
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookService.list();
        return books.stream()
                .map(t -> bookMapper.bookToDTO(t))
                .collect(Collectors.toList());

    }


}
