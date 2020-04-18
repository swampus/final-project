package com.groupj5.homework.dto.mapper;

import com.groupj5.homework.dto.BookDTO;
import com.groupj5.homework.model.v1.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public BookDTO bookToDTO(Book book){

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        return bookDTO;

    }


}
