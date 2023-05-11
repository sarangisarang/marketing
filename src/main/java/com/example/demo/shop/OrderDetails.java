package com.example.demo.shop;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderDetails{
    @Id
    private String id;
    private String Qty;
    private Integer Price;
    private Integer Subtotal;
    @ManyToOne
    @JoinColumn(name="Order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name="Product_id")

    private Product product;
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getQty(){
        return Qty;
    }

    public void setQty(String qty){
        Qty = qty;
    }

    public Integer getPrice(){
        return Price;
    }

    public void setPrice(Integer price){
        Price = price;
    }

    public Integer getSubtotal(){
        return Subtotal;
    }

    public void setSubtotal(Integer subtotal){
        Subtotal = subtotal;
    }

    public Orders getOrders(){
        return orders;

    }

    public void setOrders(Orders orders){
        this.orders = orders;
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product){
        this.product = product;
    }
}
