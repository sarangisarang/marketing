package com.example.demo.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Orders_TBl {
    public String getOrder_No() {
        return Order_No;
    }

    public void setOrder_No(String order_No) {
        Order_No = order_No;
    }

    public LocalDate getOrder_Date() {
        return Order_Date;
    }

    public void setOrder_Date(LocalDate order_Date) {
        Order_Date = order_Date;
    }

    public String getOrder_Total() {
        return Order_Total;
    }

    public void setOrder_Total(String order_Total) {
        Order_Total = order_Total;
    }

    public String getIs_Delivered() {
        return Is_Delivered;
    }

    public void setIs_Delivered(String is_Delivered) {
        Is_Delivered = is_Delivered;
    }

    public LocalDate getShipping_date() {
        return Shipping_date;
    }

    public void setShipping_date(LocalDate shipping_date) {
        Shipping_date = shipping_date;
    }

    @Id
    private String Order_No;
    private LocalDate Order_Date;
    private String Order_Total;
    private String Is_Delivered;

    private LocalDate Shipping_date;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    private String description;


    public Order_Details getOrderdetails() {
        return Orderdetails;
    }

    public void setOrderdetails(Order_Details orderdetails) {
        Orderdetails = orderdetails;
    }

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order_Details Orderdetails;
}
