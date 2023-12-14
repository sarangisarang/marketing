package com.example.demo.shop.repository;

import com.example.demo.shop.domain.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<ServiceUser, String> {
    Optional<ServiceUser> findUserByUsername(String name);
}
