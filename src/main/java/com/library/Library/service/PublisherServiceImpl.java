package com.library.Library.service;

import com.library.Library.entity.Author;
import com.library.Library.entity.Publisher;
import com.library.Library.repository.PublisherRepository;
import com.library.Library.service.dto.AuthorDto;
import com.library.Library.service.dto.PublisherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService{

    private Publisher changedPublisherDtoToPublisher(PublisherDto publisherDto){
        Publisher publisher = new Publisher();
        //publisher.setPublisherId(publisherDto.getPublisherId());
        publisher.setPublisherName(publisherDto.getPublisherName());
        return publisher;
    }

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public Publisher save(PublisherDto publisherDto) {
        Publisher publisher = changedPublisherDtoToPublisher(publisherDto);
        publisherRepository.save(publisher);
        return publisher;
    }

    @Override
    public Boolean update(PublisherDto publisherDto, Long publisherId) {
        Publisher dbPublisher =  publisherRepository.findById(publisherId).orElse(null);
        if (dbPublisher != null){
            dbPublisher.setPublisherName(publisherDto.getPublisherName());
            publisherRepository.save(dbPublisher);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean delete(Long publisherId) {
        Publisher dbPublisher =  publisherRepository.findById(publisherId).orElse(null);
        if (dbPublisher != null){
            publisherRepository.deleteById(publisherId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
