package com.example.demo.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order_Details {
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    private Integer Product_id;

    public Integer getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(Integer product_id) {
        Product_id = product_id;
    }

    public String getProduct_City() {
        return Product_City;
    }

    public void setProduct_City(String product_City) {
        Product_City = product_City;
    }

    public String getProduct_Qty() {
        return Product_Qty;
    }

    public void setProduct_Qty(String product_Qty) {
        Product_Qty = product_Qty;
    }

    public Integer getProduct_Price() {
        return Product_Price;
    }

    public void setProduct_Price(Integer product_Price) {
        Product_Price = product_Price;
    }

    public Integer getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(Integer order_id) {
        Order_id = order_id;
    }

    public Integer getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        Subtotal = subtotal;
    }

    private String Product_City;
    private String Product_Qty;
    private Integer Product_Price;
    private Integer Order_id;
    private Integer Subtotal;

}
