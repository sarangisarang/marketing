package com.example.demo.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Orders {
    @Id
    private String id;
    private Integer orderNo;
    private LocalDate orderDate;
    private Integer orderTotal;
    private LocalDate shippingDate;
    private String isDelivered;
    @ManyToOne
    @JoinColumn(name="Customer_id")

    private Customer customer;
    public Integer getOrderTotal(){
        return orderTotal;
    }
    public void setOrderTotal(Integer orderTotal){
        this.orderTotal = orderTotal;
    }
    public Integer getOrderNo(){
        return orderNo;
    }
    public void setOrderNo(Integer orderNo){
        this.orderNo = orderNo;
    }
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public LocalDate getOrderDate(){
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate){
        this.orderDate = orderDate;
    }

    public String getIsDelivered(){
        return isDelivered;
    }

    public void setIsDelivered(String isDelivered){
        this.isDelivered = isDelivered;
    }

    public LocalDate getShippingDate(){
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate){
        this.shippingDate = shippingDate;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }
}
