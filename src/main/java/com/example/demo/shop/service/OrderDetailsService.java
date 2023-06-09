package com.example.demo.shop.service;

import com.example.demo.shop.OrderDetails;
import com.example.demo.shop.Orders;
import com.example.demo.shop.Product;
import com.example.demo.shop.repository.OrderDetailsRepository;
import com.example.demo.shop.repository.OrdersRepository;
import com.example.demo.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ProductRepository productRepository;

    public OrderDetails createOrderDetails(OrderDetails orderDetails, String orderId, String productId) {
        orderDetails.setId(UUID.randomUUID().toString());
        Orders orders = ordersRepository.findById(orderId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();
        orderDetails.setOrders(orders);
        orderDetails.setProduct(product);
        return orderDetailsRepository.save(orderDetails);
    }

    public OrderDetails deleteOrderDetails(String id) {
        OrderDetails orderDetailsdelete = orderDetailsRepository.findById(id).orElseThrow();
        if (orderDetailsdelete.getOrders().getOrderStatus() == OrderStatus.Pending) {
            orderDetailsRepository.delete(orderDetailsdelete);
        } else {
            System.out.println("Not allowed to ship a Pending order");
        }
        return 
    }


    public OrderDetails UpdeteOrderDetails(OrderDetails orderDetails, Orders orders, String id) {
        OrderDetails orderDetailsToUpdate = orderDetailsRepository.findById(id).orElseThrow();
        Orders ordersstatus = ordersRepository.findById(orders.getId()).orElseThrow();
        if (ordersstatus.getOrderStatus() == OrderStatus.Pending) {
            orderDetailsToUpdate.setQty(orderDetails.getQty());
            orderDetailsToUpdate.setPrice(orderDetails.getPrice());
            orderDetailsToUpdate.setSubtotal(orderDetails.getSubtotal());
            orderDetailsRepository.save(orderDetailsToUpdate);
        } else {
            System.out.println("update/delete OrderDetails only from Pending Order");
        }
        return orderDetailsRepository.save(orderDetailsToUpdate);
    }
}
