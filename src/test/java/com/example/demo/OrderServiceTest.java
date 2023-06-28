package com.example.demo;
import com.example.demo.shop.*;
import com.example.demo.shop.repository.*;
import com.example.demo.shop.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

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
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private OrderDetailsService orderDetailsService;

//    @Test
//    public void given_order_with_status_progress_delete(){
//        Orders orders = new Orders();
//        orders.setOrderNo(20);
//        orders.setOrderTotal(50);
//        orders.setShippingDate(LocalDate.now());
//        orders.setOrderDate(LocalDate.now());
//        orders.setIsDelivered("tashipare");
//        orders.setOrderStatus(OrderStatus.Processing);
//        orders.setId("1234");
//        ordersRepository.save(orders);
//        Orders neworders =  ordersRepository.findById("1234").orElseThrow();
//        Assertions.assertNotNull(neworders);
//        Exception exception = assertThrows(Exception.class,()-> orderService.deleteOrderWithDetails(neworders.getId()));
//        assertEquals(exception.getMessage(),"Not allowed to delete  order" );
//    }
    @Test
    public void given_order_with_status_pending_delete() throws Exception {
        Orders orders = new Orders();
        orders.setOrderNo(20);
        orders.setOrderTotal(50);
        orders.setShippingDate(LocalDate.now());
        orders.setOrderDate(LocalDate.now());
        orders.setIsDelivered("tashipare");
        orders.setOrderStatus(OrderStatus.Pending);
        orders.setId("1234");
        ordersRepository.save(orders);
        Orders neworders =  ordersRepository.findById("1234").orElseThrow();
        Assertions.assertNotNull(neworders);
        orderService.deleteOrderWithDetails(neworders.getId());
        Exception exception = assertThrows(Exception.class,()-> ordersRepository.findById("1234").orElseThrow(()->new RuntimeException("order not finde")));
        assertEquals(exception.getMessage(),"order not finde");

    }
    @Test
    public void give_product_with_all_exists_delete(){
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
        Exception exception = assertThrows(Exception.class,()-> productService.deleteProduct(newproducts.getId()));
        assertEquals(exception.getMessage(),"can not delete this Product");
    }
    @Test  // testing here!
    public void give_product_with_all_not_exists_delete(){
        Product product = new Product();
        product.setProductDesc("Apfel");
        product.setProductName("Iphone");
        product.setId("2345");
//      product.setPrece();-----------------------I
//      product.setImage1();----------------------I
//      product.getImage2();----How take Values?--I
//      product.setImage3();----------------------I
//      product.setStock();-----------------------I
        Assertions.assertNotNull(product);
        Exception exception = assertThrows(Exception.class,()-> productService.deleteProduct(product.getId()));
        assertNotEquals(exception.getMessage(),"order not finde");
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
    @Test
    public void give_customer_with_all(){
        Customer customer = new Customer();
        customer.setPhone(1545453234);
        customer.setCity("Dusseldorf");
        customer.setAddress("Berlinealle50");
        customer.setPostcode(40232);
        customer.setPassword("Anonimus");
        customer.setEmail("beka.kikalishvili.it@gmail.com");
        customer.setFirstName("beka");
        customer.setLastName("kikalishvili");
        customer.setId("6789");
        customerRepository.save(customer);
        Customer newcustomer = customerRepository.findById("6789").orElseThrow();
        Assertions.assertNotNull(newcustomer);
    }
    @Test
    public void give_orderdetails_with_all(){
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setSubtotal(123);
        orderDetails.setQty("all");
        orderDetails.setId("789");
        orderDetails.setPrice(3000);
        orderDetailsRepository.save(orderDetails);
        OrderDetails neworderdetails = orderDetailsRepository.findById("789").orElseThrow();
        Assertions.assertNotNull(neworderdetails);
    }
}
