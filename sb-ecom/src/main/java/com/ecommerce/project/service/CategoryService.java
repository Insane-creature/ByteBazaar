package com.ecommerce.project.service;

import java.util.List;

import com.ecommerce.project.model.Category;

public interface CategoryService {
    List<Category> getAllCategory();

    void createCategory(Category category);

    public String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
