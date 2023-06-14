package com.example.demo;

import com.example.demo.shop.Orders;
import com.example.demo.shop.repository.OrdersRepository;
import com.example.demo.shop.service.OrderService;
import com.example.demo.shop.service.OrderStatus;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderService orderService;
    @Test
    public void given_order_with_status_progress_delete(){
        Orders orders = new Orders();
        orders.setOrderStatus(OrderStatus.Processing);
        orders.setId("1234");
        ordersRepository.save(orders);
        Orders neworders =  ordersRepository.findById("1234").orElseThrow();
        Assertions.assertNotNull(neworders);
    }
}
