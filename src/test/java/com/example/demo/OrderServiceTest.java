package com.example.demo;

import com.example.demo.shop.Category;
import com.example.demo.shop.Customer;
import com.example.demo.shop.Orders;
import com.example.demo.shop.Product;
import com.example.demo.shop.repository.CategoryRepository;
import com.example.demo.shop.repository.OrdersRepository;
import com.example.demo.shop.repository.ProductRepository;
import com.example.demo.shop.service.CategoryService;
import com.example.demo.shop.service.OrderService;
import com.example.demo.shop.service.OrderStatus;
import com.example.demo.shop.service.ProductService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

    @Test
    public void given_order_with_status_progress_delete(){
        Orders orders = new Orders();
        orders.setOrderNo(20);
        orders.setOrderTotal(50);
        orders.setShippingDate(LocalDate.now());
        orders.setOrderDate(LocalDate.now());
        orders.setIsDelivered("tashipare");
        orders.setOrderStatus(OrderStatus.Processing);
        orders.setId("1234");
        ordersRepository.save(orders);
        Orders neworders =  ordersRepository.findById("1234").orElseThrow();
        Assertions.assertNotNull(neworders);
    }
    @Test
    public void give_product_with_all(){
        Product product = new Product();
        product.setProductDesc("Apfel");
        product.setProductName("Iphone");
        product.setId("2345");
//      product.setPrece();-----------------------I
//      product.setImage1();----------------------I
//      product.getImage2();----How take Values?--I
//      product.setImage3();----------------------I
//      product.setStock();-----------------------I
        productRepository.save(product);
        Product newproducts = productRepository.findById("2345").orElseThrow();
        Assertions.assertNotNull(newproducts);
    }
    @Test
    public void give_category_with_all(){
        Category category = new Category();
        category.setName("Book");
        category.setImage("Image");
        category.setDescription("Clasica");
        category.setId("5678");
        categoryRepository.save(category);
        Category NewCategory = categoryRepository.findById("5678").orElseThrow();
        Assertions.assertNotNull(NewCategory);

    }
}
