package com.groupj5.homework.controller.v1;

import com.groupj5.homework.dto.BookContentDTO;
import com.groupj5.homework.service.BookContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rest/BookContent.svc")
public class BookContentController {

    private final BookContentService bookContentService;

    @Autowired
    public BookContentController(BookContentService bookContentService) {
        this.bookContentService = bookContentService;
    }

    @GetMapping(value = "/book({bookId})/page({pageNum})")
    public BookContentDTO getAllBooks(@PathVariable long bookId, @PathVariable long pageNum) {
        return bookContentService.getBookContentByBookIdAndPageNum(bookId, pageNum);
    }
}
