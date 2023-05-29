package com.example.demo.shop.service;

import com.example.demo.shop.Category;
import com.example.demo.shop.OrderDetails;
import com.example.demo.shop.Product;
import com.example.demo.shop.repository.CategoryRepository;
import com.example.demo.shop.repository.OrderDetailsRepository;
import com.example.demo.shop.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    public List<Product> creategetOrderedProductsByCategory(@PathVariable String categoryName){
        Category category = categoryRepository.findByName(categoryName);
        List<OrderDetails> details = orderDetailsRepository.findAllByProductCategory(category);
        return details.stream().map(d -> d.getProduct()).toList();
    }
}
