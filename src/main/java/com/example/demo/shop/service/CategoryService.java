package com.example.demo.shop.service;
import com.example.demo.shop.Category;
import com.example.demo.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepositoryDetails;

    public Category CreateCategoryOrder(Category category, String id){
        Category categoryToUpdate = categoryRepositoryDetails.findById(id).orElseThrow();
        categoryToUpdate.setName(category.getName());
        categoryToUpdate.setDescription(category.getDescription());
        categoryToUpdate.setImage(category.getImage());
        return categoryRepositoryDetails.save(categoryToUpdate);
    }
}