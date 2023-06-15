package com.example.demo.shop.repository;
import com.example.demo.shop.Category;
import com.example.demo.shop.OrderDetails;
import com.example.demo.shop.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,String>{
    List<OrderDetails> findAllByProductCategory(Category category);

    Optional<List<OrderDetails>> findAllByOrders(Orders orders);
}
