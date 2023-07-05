package com.library.Library.service;

import com.library.Library.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthor();
    Author save(Author author);
    Boolean update(Author author, Long authorId);
    Boolean delete(Long authorId);
}
