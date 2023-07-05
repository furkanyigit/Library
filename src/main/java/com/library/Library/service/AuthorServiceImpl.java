package com.library.Library.service;

import com.library.Library.entity.Author;
import com.library.Library.repository.AuthorRepository;
import com.library.Library.service.dto.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    private Author changedAuthorDtoToAuthor(AuthorDto authorDto){
        Author author = new Author();
        //author.setAuthorId(authorDto.getAuthorId());
        author.setAFirstName(authorDto.getAFirstName());
        author.setALastName(authorDto.getALastName());
        return author;
    }

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(AuthorDto authorDto) {
        Author author = changedAuthorDtoToAuthor(authorDto);
        authorRepository.save(author);
        return author;
    }

    @Override
    public Boolean update(AuthorDto authorDto, Long authorId) {
        Author dbAuthor = authorRepository.findById(authorId).orElse(null);
        if (dbAuthor != null) {
            dbAuthor.setAFirstName(authorDto.getAFirstName());
            dbAuthor.setALastName(authorDto.getALastName());
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
