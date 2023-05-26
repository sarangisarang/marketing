package com.example.demo.shop.service;

import com.example.demo.shop.OrderDetails;
import com.example.demo.shop.Product;
import com.example.demo.shop.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    public BigInteger getTotalOrderedAmount() {
    BigInteger amount = BigInteger.ZERO;
    List<OrderDetails> details = orderDetailsRepository.findAll();
    List<Product> products = details.stream().map(d -> d.getProduct()).toList();
    for (Product product : products) {
        amount = product.getPrece().add(amount);
    }
    return amount;
}
}
