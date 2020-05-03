package com.groupj5.homework.dto.mapper;

import com.groupj5.homework.dto.BookDTO;
import com.groupj5.homework.model.v1.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public BookDTO bookToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setAnnotation(book.getAnnotation());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setYear(book.getYear());
        return bookDTO;

    }

    public Book fromDTO(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setAnnotation(bookDTO.getAnnotation());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setYear(bookDTO.getYear());
        return book;
    }

}
