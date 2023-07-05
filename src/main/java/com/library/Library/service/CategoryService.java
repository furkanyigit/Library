package com.library.Library.service;

import com.library.Library.entity.Author;
import com.library.Library.entity.Category;
import com.library.Library.service.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();
    Category save(CategoryDto categoryDto);
    Boolean update(CategoryDto categoryDto, Long categoryId);
    Boolean delete(Long categoryId);
}
