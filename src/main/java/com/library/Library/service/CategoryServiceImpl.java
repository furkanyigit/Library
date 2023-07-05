package com.library.Library.service;

import com.library.Library.entity.Category;
import com.library.Library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Boolean update(Category category, Long categoryId) {
        Category dbCategory = categoryRepository.findById(categoryId).orElse(null);
        if(dbCategory != null){
            dbCategory.setCategoryName(category.getCategoryName());
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
