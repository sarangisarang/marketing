package com.example.demo.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    @Id
    private Integer category_id;
    private Integer product_id;
    private String Product_Name;
    private String Product_Desc;
    private String image1;
    private String image2;
    private String image3;

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public String getProduct_Desc() {
        return Product_Desc;
    }

    public void setProduct_Desc(String product_Desc) {
        Product_Desc = product_Desc;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public Integer getPrece() {
        return Prece;
    }

    public void setPrece(Integer prece) {
        Prece = prece;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }



    private Integer Prece;
    private String Stock;


    public Orders_TBl getOrdersTBl() {
        return ordersTBl;
    }

    public void setOrdersTBl(Orders_TBl ordersTBl) {
        this.ordersTBl = ordersTBl;
    }

    @ManyToOne
    @JoinColumn(name="product_id")
    private Orders_TBl ordersTBl;

}
