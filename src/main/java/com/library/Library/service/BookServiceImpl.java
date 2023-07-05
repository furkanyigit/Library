package com.library.Library.service;


import com.library.Library.entity.Author;
import com.library.Library.entity.Book;
import com.library.Library.repository.*;
import com.library.Library.service.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PublisherRepository publisherRepository;

    private Book changedBookDtoToBook(BookDto bookDto){
        Book book = new Book();
        //book.setBookId(bookDto.getBookId());
        book.setBookName(bookDto.getBookName());
        book.setPages(bookDto.getPages());
        book.setPublishDate(bookDto.getPublishDate());
        book.setStock(bookDto.getStock());
        Author author = authorRepository.findById(bookDto.getAuthorId());
        book.setAuthor(author);
        book.setCategory(bookDto.getCategory());
        book.setMember(bookDto.getMember());
        book.setPublisher(bookDto.getPublisher());
        return book;
    }

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(BookDto bookDto) {
        Book book = changedBookDtoToBook(bookDto);
        bookRepository.save(book);
        return book;
    }

    @Override
    public Boolean update(BookDto bookDto, Long bookId) {
        Book dbBook =  bookRepository.findById(bookId).orElse(null);
        Book book = changedBookDtoToBook(bookDto);
        if(dbBook != null){
            dbBook.setBookName(book.getBookName());
            dbBook.setPages(book.getPages());
            dbBook.setAuthor(book.getAuthor());
            dbBook.setPages(book.getPages());
            dbBook.setStock(book.getStock());
            dbBook.setCategory(book.getCategory());
            dbBook.setMember(book.getMember());
            dbBook.setPublisher(book.getPublisher());
            dbBook.setPublishDate(book.getPublishDate());
            bookRepository.save(dbBook);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean delete(Long bookId) {
        Book dbBook = bookRepository.findById(bookId).orElse(null);
        if(dbBook != null){
            bookRepository.findById(bookId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
