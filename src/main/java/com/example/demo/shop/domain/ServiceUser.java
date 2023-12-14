package com.example.demo.shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class ServiceUser {
    @Id
    private String id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<UserRole> roles;
}
