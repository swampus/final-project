package com.groupj5.homework.dto.mapper;

import com.groupj5.homework.dto.BookContentDTO;
import com.groupj5.homework.model.v1.BookContent;
import org.springframework.stereotype.Service;

@Service
public class BookContentMapper {

    public BookContent fromDto(BookContentDTO bookContentDTO){
        BookContent bookContent = new BookContent();
        bookContent.setId(bookContentDTO.getId());
        bookContent.setBookId(bookContentDTO.getBookId());
        bookContent.setContent(bookContentDTO.getContent());
        bookContent.setPageNum(bookContentDTO.getPageNum());
        return bookContent;
    }

    public BookContentDTO toDto(BookContent bookContent){
        BookContentDTO bookContentDTO = new BookContentDTO();
        bookContentDTO.setId(bookContent.getId());
        bookContentDTO.setBookId(bookContent.getBookId());
        bookContentDTO.setContent(bookContent.getContent());
        bookContentDTO.setPageNum(bookContent.getPageNum());
        return bookContentDTO;
    }

}

