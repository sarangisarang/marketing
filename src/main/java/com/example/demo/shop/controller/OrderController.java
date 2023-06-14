package com.example.demo.shop.controller;
import com.example.demo.shop.OrderDetails;
import com.example.demo.shop.Orders;
import com.example.demo.shop.repository.OrderDetailsRepository;
import com.example.demo.shop.repository.OrdersRepository;
import com.example.demo.shop.service.OrderDetailsService;
import com.example.demo.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class OrderController {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private OrderDetailsService orderDetailsService;
    @Autowired
    private OrderService orderService;

    // Orderdetails: GetMapping, PostMapping, PutMapping, DeleteMapping.
    @GetMapping("/orderdetails")
    public List<OrderDetails> getallOrderDetails(){
        return orderDetailsRepository.findAll();
    }

    @PostMapping("/orderdetail/{orderId}/{productId}") // this is work! Tested all ok!
    public OrderDetails saveOrderDetails(@RequestBody OrderDetails orderDetails, @PathVariable String orderId, @PathVariable String productId){
        return orderDetailsService.createOrderDetails(orderDetails,orderId,productId);
    }

    @GetMapping("/orderdetail/{id}")
    public OrderDetails getOrderDetails(@PathVariable String id) {
        return orderDetailsRepository.findById(id).orElseThrow();
    }

    @PutMapping("/orderdetail/{id}") // This is works, tested all ok!
    public void updateOrderdetails(@RequestBody OrderDetails orderDetails, Orders orders, @PathVariable String id){
        orderDetailsService.UpdeteOrderDetails(orderDetails,orders,id);
    }

    @DeleteMapping("/orderdetails/{id}")
    public void deleteOrderDetails(@PathVariable String id) {
        orderDetailsService.deleteOrderDetails(id);
    }

    // Order: GetMapping, PostMapping, PutMapping, DeleteMapping.

    @GetMapping("/order")
    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

    @GetMapping("/order/{id}")
    public Orders getOrder(@PathVariable String id) {
        return ordersRepository.findById(id).orElseThrow();
    }

    @PostMapping("/order/{CustumerId}") // This is works, all is ok!
    public Orders saveOrders(@RequestBody Orders orders, @PathVariable String CustumerId){
        return orderService.createSaveOrders(orders,CustumerId);
    }

    @PutMapping("/order/{id}") // This is works, all is ok!  have questions! updateCustomer??
    public Orders updateCustomer(@RequestBody Orders orders, @PathVariable String id){
        return orderService.createUpdateCustomer(orders,id);
    }

    @PutMapping("/order/{id}/process") // Test this all ok!.
    public Orders updateOrderStatusProcess(@PathVariable String id){
        return orderService.updateOrderStatusProcess(id);
    }

    @PutMapping("/order/{id}/schip") // Test this all ok!.
    public Orders updateOrderStatusSchip(@PathVariable String id){
        return orderService.updateOrderStatusSchip(id);
    }

    @PutMapping("/order/{id}/close") // Test this all ok!.
    public Orders updateOrderStatusClose(@PathVariable String id){
        return orderService.updateOrderStatusClose(id);
    }

    @PutMapping("/order/{id}/pending") // Test this all ok!.
    public Orders updateOrderStatusPending(@PathVariable String id){
        return orderService.updateOrderStatusPending(id);
    }

    @DeleteMapping("/order/{id}") // this is problem!
    public void deleteOrderWithDetails(@PathVariable String id) throws Exception {
      orderService.deleteOrderWithDetails(id);
    }
}