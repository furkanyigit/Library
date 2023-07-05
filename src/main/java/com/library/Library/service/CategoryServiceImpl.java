package com.library.Library.service;

import com.library.Library.entity.Author;
import com.library.Library.entity.Category;
import com.library.Library.repository.CategoryRepository;
import com.library.Library.service.dto.AuthorDto;
import com.library.Library.service.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private Category changedCategoryDtoToCategory(CategoryDto categoryDto){
        Category category = new Category();
        //category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryName(categoryDto.getCategoryName());
        return category;
    }
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(CategoryDto categoryDto) {
        Category category = changedCategoryDtoToCategory(categoryDto);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Boolean update(CategoryDto categoryDto, Long categoryId) {
        Category dbCategory = categoryRepository.findById(categoryId).orElse(null);
        if(dbCategory != null){
            dbCategory.setCategoryName(categoryDto.getCategoryName());
            categoryRepository.save(dbCategory);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean delete(Long categoryId) {
        Category dbCategory = categoryRepository.findById(categoryId).orElse(null);
        if(dbCategory != null){
            categoryRepository.deleteById(categoryId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
