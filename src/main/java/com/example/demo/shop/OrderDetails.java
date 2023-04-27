package com.example.demo.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderDetails{
    @Id
    private Long Order_Details_id;

    private String Product_Qty;
    private Integer Product_Price;

    private Integer Subtotal;

    public Long getOrder_Details_id() {
        return Order_Details_id;
    }

    public void setOrder_Details_id(Long order_Details_id) {
        Order_Details_id = order_Details_id;
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

    public Integer getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        Subtotal = subtotal;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name="Order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name="Product_id")
    private Product product;
}
