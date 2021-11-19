package com.webapplication.crossport.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.webapplication.crossport.models.Category;
import com.webapplication.crossport.models.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void saveCategory(Category category) {
        this.categoryRepository.save(category);
    }

    public Category getCategoryById(Integer id) {
        Optional<Category> optional = categoryRepository.findById(id);
        Category category;
        if (optional.isPresent()) {
            category = optional.get();
        } else {
            throw new RuntimeException("Category not found for id :: " + id);
        }
        return category;
    }

    public void deleteCategory(Integer id) {
        this.categoryRepository.deleteById(id);
    }

    public Category getFirstByName(String name) {
        return categoryRepository.findFirstByName(name);
    }
}