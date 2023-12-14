package com.example.demo.shop.repository;
import com.example.demo.shop.domain.Category;
import com.example.demo.shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product,String>{
     List <Product> findAllByCategoryName(String categoryName);

     Optional<List<Product>> findAllByCategory(Category category); // testing here
}
