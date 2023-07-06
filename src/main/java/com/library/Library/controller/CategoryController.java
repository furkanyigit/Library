package com.library.Library.controller;

import com.library.Library.entity.Book;
import com.library.Library.entity.Category;
import com.library.Library.service.CategoryService;
import com.library.Library.service.CategoryServiceImpl;
import com.library.Library.service.dto.CategoryDto;
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
    public Category save(@RequestBody CategoryDto categoryDto){
        return categoryService.save(categoryDto);
    }

    @PutMapping("/update/{categoryId}")
    public Boolean update(@RequestBody CategoryDto categoryDto, @PathVariable Long categoryId){
        return categoryService.update(categoryDto,categoryId);
    }

    @DeleteMapping("/delete/{categoryId}")
    public Boolean delete(@PathVariable Long categoryId){
        return categoryService.delete(categoryId);
    }
}
