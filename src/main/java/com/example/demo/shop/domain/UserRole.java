package com.example.demo.shop.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserRole {
    @Id
    private String id;
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private ServiceUser user;
}
