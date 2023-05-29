package com.example.demo.shop.controller;

import com.example.demo.shop.*;
import com.example.demo.shop.repository.*;
import com.example.demo.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.math.BigInteger;
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
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderDetailsService orderDetailsService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    //GetMapping, PostMapping, PutMapping, DeleteMapping.

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable String id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @PostMapping("/category")
    public Category saveorders(@RequestBody Category category){
        category.setId(UUID.randomUUID().toString());
        return categoryRepository.save(category);
    }

    @PutMapping("/category/{id}") // This is tested, works.
    public Category updateCategory(@RequestBody Category category, @PathVariable String id){
        return categoryService.CreateCategoryOrder(category,id);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable String id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(category);
    }

    //GetMapping, GetMappig(add Id), PostMapping, PutMapping, DeleteMapping.

    @GetMapping("/customers")
    public List<Customer> getAllCustumeries(){
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustumer(@PathVariable String id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @PostMapping("/customer")
    public Customer saveCustumer(@RequestBody Customer customer){
        customer.setId(UUID.randomUUID().toString());
        return customerRepository.save(customer);
    }

    @PutMapping("/customer/{id}") // this is works, Tested all ok!
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable String id){
        return customerService.CreateCustomerOrder(customer,id);
    }

    @DeleteMapping("/customer/{id}")
    public void deletecustomer(@PathVariable String id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customer);
    }

    // GetMapping, PostMapping, PutMapping, DeleteMapping.

    @GetMapping("/orderdetails")
    public  List<OrderDetails> getallOrderDetails(){
        return orderDetailsRepository.findAll();
    }

    @PostMapping("/orderdetail/{orderId}/{productId}") // this is work! Tested all ok!
    public OrderDetails saveorderdetails(@RequestBody OrderDetails orderDetails,@PathVariable String orderId, @PathVariable String productId){
        return orderDetailsService.createorderdetals(orderDetails,orderId,productId);
    }

    @GetMapping("/orderdetail/{id}")
    public OrderDetails getOrderDetails(@PathVariable String id) {
        return orderDetailsRepository.findById(id).orElseThrow();
    }

    @PutMapping("/orderdetail/{id}") // This is works, tested all ok!
    public OrderDetails updateCustomer(@RequestBody OrderDetails orderDetails, @PathVariable String id){
        return orderDetailsService.creatupdetecustomer(orderDetails,id);
    }

    @DeleteMapping("/orderdetails/{id}")
    public void deleteorderdetails(@PathVariable String id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).orElseThrow();
        orderDetailsRepository.delete(orderDetails);
    }

    // GetMapping, PostMapping, PutMapping, DeleteMapping.

    @GetMapping("/order")
    public List<Orders> getallorders(){
        return ordersRepository.findAll();
    }

    @GetMapping("/order/{id}")
    public Orders getOrder(@PathVariable String id) {
        return ordersRepository.findById(id).orElseThrow();
    }

    @PostMapping("/order/{CustumerId}") // This is works, all is ok!
    public Orders saveorders(@RequestBody Orders orders, @PathVariable String CustumerId){
        return orderService.createsaveorders(orders,CustumerId);
    }

    @PutMapping("/order/{id}")
    public Orders updateCustomer(@RequestBody Orders orders, @PathVariable String id){
        Orders ordersToUpdate = ordersRepository.findById(id).orElseThrow();
        ordersToUpdate.setOrderNo(orders.getOrderNo());
        ordersToUpdate.setOrderDate(orders.getOrderDate());
        ordersToUpdate.setOrderTotal(orders.getOrderTotal());
        ordersToUpdate.setShippingDate(orders.getShippingDate());
        ordersToUpdate.setIsDelivered(orders.getIsDelivered());
        return ordersRepository.save(ordersToUpdate);
    }

    @PutMapping("/order/{id}/{status}")
    public Orders updateOrderStatus(@PathVariable String id, @PathVariable String status){
        Orders ordersToUpdate = ordersRepository.findById(id).orElseThrow();
        ordersToUpdate.setOrderStatus(OrderStatus.Processing);
        return ordersRepository.save(ordersToUpdate);
    }

    @DeleteMapping("/order/{id}")
    public void deleteorders(@PathVariable String id) {
        Orders orders = ordersRepository.findById(id).orElseThrow();
        ordersRepository.delete(orders);
    }

    // GetMapping, PostMapping, PutMapping, DeleteMapping.

    @GetMapping("/products")
    public List<Product> getallproduct(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{categoryName}")
    public List<Product> getproductsByCategory(@PathVariable String categoryName){
        return productRepository.findAllByCategoryName(categoryName);
    }

    @GetMapping("/products/{categoryName}/შეკვეთილი")
    public List<Product> getOrderedProductsByCategory(@PathVariable String categoryName){
        Category category = categoryRepository.findByName(categoryName);
        List<OrderDetails> details = orderDetailsRepository.findAllByProductCategory(category);
        return details.stream().map(d -> d.getProduct()).toList();
    }

    @GetMapping("/products/შეკვეთილი")
    public BigInteger getTotalOrderedAmount() {
        BigInteger amount = BigInteger.ZERO;
        List<OrderDetails> details = orderDetailsRepository.findAll();
        List<Product> products = details.stream().map(d -> d.getProduct()).toList();
        for (Product product : products) {
            amount = product.getPrece().add(amount);
        }
        return amount;
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable String id) {
        return productRepository.findById(id).orElseThrow();
    }

    @PostMapping("/product/{categoryId}")
    public Product saveProduct(@RequestBody Product product, @PathVariable String categoryId){
        product.setId(UUID.randomUUID().toString());
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        product.setCategory(category);
        return productRepository.save(product);
    }

    @PutMapping("/product/{id}")
    public Product updateProucts(@RequestBody Product product, @PathVariable String id){
        Product productsToUpdate = productRepository.findById(id).orElseThrow();
        productsToUpdate.setProductName(product.getProductName());
        productsToUpdate.setProductDesc(product.getProductDesc());
        productsToUpdate.setImage1(product.getImage1());
        productsToUpdate.setImage2(product.getImage2());
        productsToUpdate.setImage3(product.getImage3());
        productsToUpdate.setPrece(product.getPrece());
        productsToUpdate.setStock(product.getStock());
        return productRepository.save(productsToUpdate);
    }

    @DeleteMapping("/product/{id}")
    public void deleteproducts(@PathVariable String id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);

    }
}