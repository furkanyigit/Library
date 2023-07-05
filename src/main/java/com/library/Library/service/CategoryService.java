package com.library.Library.service;

import com.library.Library.entity.Author;
import com.library.Library.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();
    Category save(Category category);
    Boolean update(Category category, Long categoryId);
    Boolean delete(Long categoryId);
}
