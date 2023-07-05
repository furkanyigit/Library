package com.library.Library.service;

import com.library.Library.entity.Publisher;
import com.library.Library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService{

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public Publisher save(Publisher publisher) {
        publisherRepository.save(publisher);
        return publisher;
    }

    @Override
    public Boolean update(Publisher publisher, Long publisherId) {
        Publisher dbPublisher =  publisherRepository.findById(publisherId).orElse(null);
        if (dbPublisher != null){
            dbPublisher.setPublisherName(publisher.getPublisherName());
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
