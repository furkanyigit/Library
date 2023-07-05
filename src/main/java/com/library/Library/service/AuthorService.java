package com.library.Library.service;

import com.library.Library.entity.Author;
import com.library.Library.service.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthor();
    Author save(AuthorDto authorDto);
    Boolean update(AuthorDto authorDto, Long authorId);
    Boolean delete(Long authorId);
}
