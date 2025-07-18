package com.ecommerce.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {

    // private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        // category.setCategoryId(nextId++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
        
        // List<Category> categories = categoryRepository.findAll();
        // Category category = categories.stream()
        //         .filter(c -> c.getCategoryId().equals(categoryId))
        //         .findFirst()
        //         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        categoryRepository.delete(category);
        return "Category with categoryId: " + categoryId + " deleted successfully !!";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        // Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);

        // optmised below
        Category savedCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;

        // List<Category> categories = categoryRepository.findAll();

        // Optional<Category> optionalCategory = categories.stream()
        //         .filter(c -> c.getCategoryId().equals(categoryId))
        //         .findFirst();

        // if (optionalCategory.isPresent()) {
        //     Category existingCategory = optionalCategory.get();
        //     existingCategory.setCategoryName(category.getCategoryName());
        //     Category savedCategory = categoryRepository.save(existingCategory);
        //     return savedCategory;
        // } else {
        //     throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        // }

    }

}
