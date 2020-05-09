package com.groupj5.homework.service;

import com.groupj5.homework.dto.BookContentDTO;
import com.groupj5.homework.dto.mapper.BookContentMapper;
import com.groupj5.homework.model.v1.BookContent;
import com.groupj5.homework.repository.BookContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookContentService {

    private final BookContentRepository bookContentRepository;
    private final BookContentMapper bookContentMapper;


    @Autowired
    public BookContentService(BookContentRepository bookContentRepository, BookContentMapper bookContentMapper) {
        this.bookContentRepository = bookContentRepository;
        this.bookContentMapper = bookContentMapper;
    }

    public BookContentDTO getBookContentByBookIdAndPageNum(long bookId, long pageNum){
        return bookContentMapper.toDto(bookContentRepository.searchBooksContent(bookId, pageNum));
    }
}
