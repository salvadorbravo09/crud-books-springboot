package com.salvadorbravo.crudbooks.services;

import com.salvadorbravo.crudbooks.model.Category;
import com.salvadorbravo.crudbooks.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Integer idCategory, Category category) {
        category.setIdCategory(idCategory);
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategorys() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer idCategory) {
        return this.categoryRepository.findById(idCategory).orElseThrow();
    }

    @Override
    public void deleteCategory(Integer idCategory) {
        this.categoryRepository.deleteById(idCategory);
    }
}
