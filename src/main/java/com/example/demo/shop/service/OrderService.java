package com.example.demo.shop.service;

import com.example.demo.shop.Customer;
import com.example.demo.shop.OrderDetails;
import com.example.demo.shop.Orders;
import com.example.demo.shop.Product;
import com.example.demo.shop.repository.CategoryRepository;
import com.example.demo.shop.repository.CustomerRepository;
import com.example.demo.shop.repository.OrderDetailsRepository;
import com.example.demo.shop.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    private CustomerRepository customerRepository;
    private OrdersRepository ordersRepository;

    public BigInteger getTotalOrderedAmount() {
        BigInteger amount = BigInteger.ZERO;
        List<OrderDetails> details = orderDetailsRepository.findAll();
        List<Product> products = details.stream().map(d -> d.getProduct()).toList();
        for (Product product : products) {
            amount = product.getPrece().add(amount);
        }
        return amount;
    }

    public Orders createsaveorders(@RequestBody Orders orders, @PathVariable String CustumerId) {
        orders.setId(UUID.randomUUID().toString());
        Customer customer = customerRepository.findById(CustumerId).orElseThrow();
        orders.setCustomer(customer);
        return ordersRepository.save(orders);
    }

    public Orders createupdateCustomer(@RequestBody Orders orders, @PathVariable String id) {
        Orders ordersToUpdate = ordersRepository.findById(id).orElseThrow();
        ordersToUpdate.setOrderNo(orders.getOrderNo());
        ordersToUpdate.setOrderDate(orders.getOrderDate());
        ordersToUpdate.setOrderTotal(orders.getOrderTotal());
        ordersToUpdate.setShippingDate(orders.getShippingDate());
        ordersToUpdate.setIsDelivered(orders.getIsDelivered());
        return ordersRepository.save(ordersToUpdate);
    }
    public Orders crateupdateOrderStatus(@PathVariable String id, @PathVariable String status){
        Orders ordersToUpdate = ordersRepository.findById(id).orElseThrow();
        ordersToUpdate.setOrderStatus(OrderStatus.shipped);
        return ordersRepository.save(ordersToUpdate);
    }
}