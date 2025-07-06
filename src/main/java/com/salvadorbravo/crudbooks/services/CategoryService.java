package com.salvadorbravo.crudbooks.services;

import com.salvadorbravo.crudbooks.model.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);

    Category updateCategory(Integer idCategory, Category category);

    List<Category> getAllCategorys();

    Category getCategoryById(Integer idCategory);

    void deleteCategory(Integer idCategory);
}
