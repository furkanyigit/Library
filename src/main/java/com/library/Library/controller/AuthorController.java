package com.library.Library.controller;

import com.library.Library.entity.Author;
import com.library.Library.service.AuthorService;
import com.library.Library.service.dto.AuthorDto;
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
    public /*ResponseEntity<AuthorDto> */ AuthorDto save(@RequestBody AuthorDto authorDto){
         authorService.save(authorDto);
         return authorDto;
        // return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }
    @PutMapping("/update/{authorId}")
    public Boolean update(@RequestBody AuthorDto authorDto, @PathVariable Long authorId){
        return authorService.update(authorDto,authorId);
    }
    @DeleteMapping("/delete/{authorId}")
    public Boolean delete(@PathVariable Long authorId){
        return authorService.delete(authorId);
    }
}
