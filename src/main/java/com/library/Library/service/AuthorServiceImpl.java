package com.library.Library.service;

import com.library.Library.entity.Author;
import com.library.Library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        authorRepository.save(author);
        return author;
    }

    @Override
    public Boolean update(Author author, Long authorId) {
        Author dbAuthor = authorRepository.findById(authorId).orElse(null);
        if (dbAuthor != null) {
            dbAuthor.setAFirstName(author.getAFirstName());
            dbAuthor.setALastName(author.getALastName());
            authorRepository.save(dbAuthor);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean delete(Long authorId) {
        Author dbAuthor = authorRepository.findById(authorId).orElse(null);
        if (dbAuthor != null) {
            authorRepository.deleteById(authorId);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
