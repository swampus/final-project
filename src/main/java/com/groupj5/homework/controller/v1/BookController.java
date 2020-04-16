package com.groupj5.homework.controller.v1;

import com.groupj5.homework.model.v1.Book;
import com.groupj5.homework.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest/Book")
public class BookController {


    //TODO : what wrong ?
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public List<Book> getAllBooks() {
        return bookService.list();
    }

}
