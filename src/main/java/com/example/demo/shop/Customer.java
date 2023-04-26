package com.example.demo.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {


    @Id
    private Long Customer_id;
    private String Costumer_email;
    private String First_name;
    private String Last_name;
    private String Password;
    private String Address;
    private Integer Postcode;
    private String City;
    private Integer Phone;


    public Long getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        Customer_id = customer_id;
    }

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
}
