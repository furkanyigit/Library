package com.library.Library.controller;

import com.library.Library.entity.Book;
import com.library.Library.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping("get-all")
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Book> save(@RequestBody Book book){
        Book createdBook = bookService.save(book);
        return new ResponseEntity<>(createdBook , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Boolean update(@RequestBody Book book, @PathVariable Long id){
        return bookService.update(book, id);
    }
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return bookService.delete(id);
    }
}
