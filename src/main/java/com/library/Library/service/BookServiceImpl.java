package com.library.Library.service;

import com.library.Library.entity.Book;
import com.library.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public Boolean update(Book book, Long bookId) {
        Book dbBook =  bookRepository.findById(bookId).orElse(null);
        if(dbBook != null){
            dbBook.setBookName(book.getBookName());
            dbBook.setPages(dbBook.getPages());
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
