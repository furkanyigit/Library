package com.library.Library.controller;

import com.library.Library.entity.Book;
import com.library.Library.service.BookServiceImpl;
import com.library.Library.service.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book" )
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping("get-all")
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto){
        Book createdBook = bookService.save(bookDto);
        return new ResponseEntity<>(createdBook , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Boolean update(@RequestBody BookDto bookDto, @PathVariable Long id){

        return bookService.update(bookDto, id);
    }
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return bookService.delete(id);
    }
}
