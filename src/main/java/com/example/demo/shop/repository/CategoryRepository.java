package com.example.demo.shop.repository;
import com.example.demo.shop.Category;
import com.example.demo.shop.OrderDetails;
import com.example.demo.shop.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
    Category findByName(String categoryName);
}
