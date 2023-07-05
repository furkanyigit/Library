package com.library.Library.controller;

import com.library.Library.entity.Book;
import com.library.Library.entity.Category;
import com.library.Library.service.CategoryService;
import com.library.Library.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("/get-all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/save")
    public Category save(@RequestBody  Category category){
        return categoryService.save(category);
    }

    @PutMapping("/update/{id}")
    public Boolean update(@RequestBody Category category, @RequestParam Long categoryId){
        return categoryService.update(category,categoryId);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@RequestParam Long categoryId){
        return categoryService.delete(categoryId);
    }
}
