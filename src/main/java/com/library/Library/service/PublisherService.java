package com.library.Library.service;

import com.library.Library.entity.Author;
import com.library.Library.entity.Publisher;

public interface PublisherService {

    Publisher save(Publisher publisher);
    Boolean update(Publisher publisher, Long publisherId);
    Boolean delete(Long publisherId);
}
