package com.salvadorbravo.crudbooks.controller;

import com.salvadorbravo.crudbooks.model.Category;
import com.salvadorbravo.crudbooks.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategorys();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity<Category> getCategoryById(Integer idCategory) {
        Category category = categoryService.getCategoryById(idCategory);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }
}
