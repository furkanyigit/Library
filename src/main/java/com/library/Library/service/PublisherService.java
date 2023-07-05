package com.library.Library.service;

import com.library.Library.entity.Author;
import com.library.Library.entity.Publisher;
import com.library.Library.service.dto.PublisherDto;

public interface PublisherService {

    Publisher save(PublisherDto publisherDto);
    Boolean update(PublisherDto publisherDto, Long publisherId);
    Boolean delete(Long publisherId);
}
