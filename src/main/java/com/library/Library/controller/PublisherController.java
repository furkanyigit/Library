package com.library.Library.controller;

import com.library.Library.entity.Member;
import com.library.Library.entity.Publisher;
import com.library.Library.service.PublisherServiceImpl;
import com.library.Library.service.dto.PublisherDto;
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
    public ResponseEntity<Publisher> save(@RequestBody PublisherDto publisherDto){
        Publisher publisher1 =  publisherService.save(publisherDto);
        return new ResponseEntity<>(publisher1, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Boolean update(@RequestBody PublisherDto publisherDto, @RequestParam Long publisherId){
        return publisherService.update(publisherDto,publisherId);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@RequestParam Long publisherId){
        return publisherService.delete(publisherId);
    }
}
