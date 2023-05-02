package com.example.demo.shop.controller;

import com.example.demo.shop.*;
import com.example.demo.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shop")
public class ShopController{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @PostMapping("/category")
    public Category saveCategory(@RequestBody Category category){
        category.setId(UUID.randomUUID().toString()); return categoryRepository.save(category);}

    @GetMapping("/customeries")
    public List<Customer> getAllCustumeries(){
        return customerRepository.findAll();
    }

    @PostMapping("/customery")
    public Customer saveCustumer(@RequestBody Customer customer){
        customer.setId(UUID.randomUUID().toString()); return customerRepository.save(customer);}

    @GetMapping("/orderdetailies")
    public  List<OrderDetails> getallOrderDetails(){
        return orderDetailsRepository.findAll();
    }
    @PostMapping("/orderdetails")
    public OrderDetails saveorderdetails(@RequestBody OrderDetails orderDetails){
        orderDetails.setId(UUID.randomUUID().toString()); return orderDetailsRepository.save(orderDetails);}

    @GetMapping("/Orderies")
    public List<Orders> getallorders(){
        return ordersRepository.findAll();
    }
    @PostMapping("/orders")
    public Orders saveorders(@RequestBody Orders orders){
        orders.setId(UUID.randomUUID().toString()); return ordersRepository.save(orders);}

    @GetMapping("/producties")
    public List<Product> getallproduct(){
        return productRepository.findAll();
    }
    @PostMapping("/Product")
    public Product saveorders(@RequestBody Product product){
        product.setId(UUID.randomUUID().toString()); return productRepository.save(product);}
}
