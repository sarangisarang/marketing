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

    //GetMapping, PostMapping, PutMapping, DeleteMapping
    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    @GetMapping("/categoryid/{id}")
    public Category getCategory(@PathVariable String id) {
        return categoryRepository.findById(id).orElseThrow();
    }
    @PostMapping("/category")
    public Category saveCategory(@RequestBody Category category){
        category.setId(UUID.randomUUID().toString()); return categoryRepository.save(category);
    }
    @PutMapping("/categoryput/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable String id){
        Category categoryToUpdate = categoryRepository.findById(id).orElseThrow();
        categoryToUpdate.setName(category.getName());
        return categoryRepository.save(categoryToUpdate);
    }
    @DeleteMapping("/categorydel/{id}")
    public void deleteCategory(@PathVariable String id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(category);
    }
    //GetMapping, Getmappig(add Id), PostMapping, PutMapping, DeleteMapping
    @GetMapping("/customers")
    public List<Customer> getAllCustumeries(){
        return customerRepository.findAll();
    }
    @GetMapping("/customerid/{id}")
    public Customer getCustumer(@PathVariable String id) {
        return customerRepository.findById(id).orElseThrow();
    }
    @PostMapping("/customer")
    public Customer saveCustumer(@RequestBody Customer customer){
        customer.setId(UUID.randomUUID().toString()); return customerRepository.save(customer);
    }
    @PutMapping("/customerPut/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable String id){
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
        customerToUpdate.setLastName(customer.getFirstName());
        return customerRepository.save(customerToUpdate);
    }
    @DeleteMapping("/customerdel/{id}")
    public void deletecustomer(@PathVariable String id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customer);
    }
    // GetMapping, PostMapping, PutMapping, DeleteMapping
    @GetMapping("/orderdetails")
    public  List<OrderDetails> getallOrderDetails(){
        return orderDetailsRepository.findAll();
    }
    @PostMapping("/orderdetail")
    public OrderDetails saveorderdetails(@RequestBody OrderDetails orderDetails){
        orderDetails.setId(UUID.randomUUID().toString()); return orderDetailsRepository.save(orderDetails);
    }
    @GetMapping("/orderdetailid/{id}")
    public OrderDetails getOrderDetails(@PathVariable String id) {
        return orderDetailsRepository.findById(id).orElseThrow();
    }
    @PutMapping("/orderdetailput/{id}")
    public OrderDetails updateCustomer(@RequestBody OrderDetails orderDetails, @PathVariable String id){
        OrderDetails orderDetailsToUpdate = orderDetailsRepository.findById(id).orElseThrow();
        orderDetailsToUpdate.setQty(orderDetailsToUpdate.getId());
        return orderDetailsRepository.save(orderDetailsToUpdate);
    }
    @DeleteMapping("/orderdetailsdel/{id}")
    public void deleteorderdetails(@PathVariable String id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).orElseThrow();
        orderDetailsRepository.delete(orderDetails);
    }
    // GetMapping, PostMapping, PutMapping, DeleteMapping
    @GetMapping("/orders")
    public List<Orders> getallorders(){
        return ordersRepository.findAll();
    }
    @GetMapping("/ordersid/{id}")
    public Orders getOrder(@PathVariable String id) {
        return ordersRepository.findById(id).orElseThrow();
    }
    @PostMapping("/orders")
    public Orders saveorders(@RequestBody Orders orders){
        orders.setId(UUID.randomUUID().toString()); return ordersRepository.save(orders);}
    @PutMapping("/ordersput/{id}")
    public Orders updateCustomer(@RequestBody Orders orders, @PathVariable String id){
        Orders ordersToUpdate = ordersRepository.findById(id).orElseThrow();
        ordersToUpdate.setOrderNo(ordersToUpdate.getOrderNo());
        return ordersRepository.save(ordersToUpdate);
    }
    @DeleteMapping("/ordersdel/{id}")
    public void deleteorders(@PathVariable String id) {
        Orders orders = ordersRepository.findById(id).orElseThrow();
        ordersRepository.delete(orders);
    }
    // GetMapping, PostMapping, PutMapping, DeleteMapping
    @GetMapping("/products")
    public List<Product> getallproduct(){
        return productRepository.findAll();
    }
    @GetMapping("/productsid/{id}")
    public Product getProduct(@PathVariable String id) {
        return productRepository.findById(id).orElseThrow();
    }
    @PostMapping("/product")
    public Product saveorders(@RequestBody Product product){
        product.setId(UUID.randomUUID().toString()); return productRepository.save(product);
    }
    @PutMapping("/productsput/{id}")
    public Product updateProucts(@RequestBody Product product, @PathVariable String id){
        Product productsToUpdate = productRepository.findById(id).orElseThrow();
        productsToUpdate.setProductName(productsToUpdate.getProductName());
        return productRepository.save(productsToUpdate);
    }
    @DeleteMapping("/productsdel/{id}")
    public void deleteproducts(@PathVariable String id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
    }
}
