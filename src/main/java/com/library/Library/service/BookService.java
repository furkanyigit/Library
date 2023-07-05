package com.library.Library.service;

import com.library.Library.entity.Author;
import com.library.Library.entity.Book;
import com.library.Library.service.dto.BookDto;

import java.util.List;

public interface BookService {

    List<Book> getAll();
    Book save(BookDto bookDto);
    Boolean update(BookDto bookDto, Long bookId);
    Boolean delete(Long bookId);

}
