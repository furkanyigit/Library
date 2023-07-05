package com.library.Library.controller;

import com.library.Library.entity.Member;
import com.library.Library.entity.Publisher;
import com.library.Library.service.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    PublisherServiceImpl publisherService;

    @PostMapping("/save")
    public ResponseEntity<Publisher> save(@RequestBody Publisher publisher){
        Publisher publisher1 =  publisherService.save(publisher);
        return new ResponseEntity<>(publisher1, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Boolean update(@RequestBody Publisher publisher, @RequestParam Long publisherId){
        return publisherService.update(publisher,publisherId);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@RequestParam Long publisherId){
        return publisherService.delete(publisherId);
    }
}
