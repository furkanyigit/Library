package com.library.Library.service;

import com.library.Library.entity.Author;
import com.library.Library.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();
    Book save(Book book);
    Boolean update(Book book, Long bookId);
    Boolean delete(Long bookId);

}
