package com.groupj5.homework.controller.v1;

import com.google.common.collect.ImmutableMap;
import com.groupj5.homework.dto.BookDTO;
import com.groupj5.homework.dto.mapper.BookMapper;
import com.groupj5.homework.exceptions.ServiceException;
import com.groupj5.homework.handler.ErrorCode;
import com.groupj5.homework.model.v1.Book;
import com.groupj5.homework.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "/books$filter={searchStr}")
    public List<BookDTO> filterBooks(@PathVariable String searchStr) {
        System.out.println("SearchStr:: " + searchStr);
        if(searchStr == null || searchStr.isEmpty() || searchStr.equals("undefined")){
            throw new ServiceException(ErrorCode.GEN_USR_30,
                    ImmutableMap.of("searchStr", ""), "en");
        }

        return bookService.filterBooks(searchStr);
    }

}
