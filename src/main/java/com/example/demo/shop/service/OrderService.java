package com.example.demo.shop.service;

import com.example.demo.shop.Customer;
import com.example.demo.shop.OrderDetails;
import com.example.demo.shop.Orders;
import com.example.demo.shop.Product;
import com.example.demo.shop.repository.CustomerRepository;
import com.example.demo.shop.repository.OrderDetailsRepository;
import com.example.demo.shop.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
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

    public Orders createSaveOrders(@RequestBody Orders orders,String CustumerId) {
        orders.setId(UUID.randomUUID().toString());
        Customer customer = customerRepository.findById(CustumerId).orElseThrow();
        orders.setCustomer(customer);
        return ordersRepository.save(orders);
    }

    public Orders createUpdateCustomer(@RequestBody Orders orders,String id) {
        Orders ordersToUpdate = ordersRepository.findById(id).orElseThrow();
        ordersToUpdate.setOrderNo(orders.getOrderNo());
        ordersToUpdate.setOrderDate(orders.getOrderDate());
        ordersToUpdate.setOrderTotal(orders.getOrderTotal());
        ordersToUpdate.setShippingDate(orders.getShippingDate());
        ordersToUpdate.setIsDelivered(orders.getIsDelivered());
        return ordersRepository.save(ordersToUpdate);
    }

    public Orders updateOrderStatusProcess(String id){
        Orders ordersToUpdate = ordersRepository.findById(id).orElseThrow();
        ordersToUpdate.setOrderStatus(OrderStatus.Processing);
        return ordersRepository.save(ordersToUpdate);
    }

    public Orders updateOrderStatusSchip(String id){
        Orders ordersToUpdate = ordersRepository.findById(id).orElseThrow();
        ordersToUpdate.setOrderStatus(OrderStatus.shipped);
        return ordersRepository.save(ordersToUpdate);
    }

    public Orders updateOrderStatusClose(String id){
        Orders ordersToUpdate = ordersRepository.findById(id).orElseThrow();
        ordersToUpdate.setOrderStatus(OrderStatus.closed);
        return ordersRepository.save(ordersToUpdate);
    }
}