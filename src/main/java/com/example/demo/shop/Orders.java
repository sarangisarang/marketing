package com.example.demo.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Orders {


    @Id
    private Long Order_id;
    private String Order_No;
    private LocalDate Order_Date;
    private String Order_Total;
    private String Customer_id;
    private LocalDate Shipping_date;
    private String Is_Delivered;


    public Long getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(Long order_id) {
        Order_id = order_id;
    }

    public String getCustomer_id() {
        return Customer_id;
    }


    public void setCustomer_id(String customer_id) {
        Customer_id = customer_id;
    }


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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name="Customer_id", nullable=false)
    private Customer customer;
}
