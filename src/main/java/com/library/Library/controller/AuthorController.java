package com.library.Library.controller;

import com.library.Library.entity.Author;
import com.library.Library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping ("/get-all")
    public List<Author> getAllAuthor() {
        return authorService.getAllAuthor();
    }
    @PostMapping("/save")
    public ResponseEntity<Author> save(@RequestBody Author author){
        Author createdAuthor =  authorService.save(author);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public Boolean update(@RequestBody Author author, @RequestParam Long authorId){
        return authorService.update(author,authorId);
    }
    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam Long authorId){
        return authorService.delete(authorId);
    }
}
