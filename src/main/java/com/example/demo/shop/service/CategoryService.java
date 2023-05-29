package com.example.demo.shop.service;
import com.example.demo.shop.Category;
import com.example.demo.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepositorydetails;
    public Category CreateCategoryOrder(Category category, String id){
        Category categoryToUpdate = categoryRepositorydetails.findById(id).orElseThrow();
        categoryToUpdate.setName(category.getName());
        categoryToUpdate.setDescription(category.getDescription());
        categoryToUpdate.setImage(category.getImage());
        return categoryRepositorydetails.save(categoryToUpdate);
    }
}