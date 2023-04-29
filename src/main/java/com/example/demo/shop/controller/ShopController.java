package com.example.demo.shop.controller;

import com.example.demo.shop.Category;
import com.example.demo.shop.Customer;
import com.example.demo.shop.service.CategoryRepository;
import com.example.demo.shop.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    @PostMapping("/custumeries")
    public List<Customer> getAllCustumeries(){
        return customerRepository.findAll();
    }
}
