package com.example.demo.shop.repository;
import com.example.demo.shop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
    Category findByName(String categoryName);
}
