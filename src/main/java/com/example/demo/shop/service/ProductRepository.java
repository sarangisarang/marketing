package com.example.demo.shop.service;

import com.example.demo.shop.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String>{
}
