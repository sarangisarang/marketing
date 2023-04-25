package com.example.demo.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Customer {

    @Id
    private Long id;
    private String name;
    private String Costumer_email;

    public String getCostumer_email() {
        return Costumer_email;
    }

    public void setCostumer_email(String costumer_email) {
        Costumer_email = costumer_email;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getPostcode() {
        return Postcode;
    }

    public void setPostcode(Integer postcode) {
        Postcode = postcode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }

    private String First_name;
    private String Last_name;
    private String Password;
    private String Address;
    private Integer Postcode;
    private String City;
    private Integer Phone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Orders getOrdersTBl1() {
        return ordersTBl1;
    }

    public void setOrdersTBl1(Orders ordersTBl1) {
        this.ordersTBl1 = ordersTBl1;
    }

    @ManyToOne
    @JoinColumn(name="product_id")
    private Orders ordersTBl1;
}
