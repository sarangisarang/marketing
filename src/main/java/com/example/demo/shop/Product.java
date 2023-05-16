package com.example.demo.shop;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigInteger;

@Entity
public class Product {
    @Id
    private String id;
    private String productName;
    private String productDesc;
    private byte[] image1;
    private byte[] image2;
    private byte[] image3;
    private BigInteger Prece;
    private BigInteger Stock;
    @ManyToOne
    @JoinColumn(name="Category_id")
    private Category category;


    public byte[] getImage2() {
        return image2;
    }

    public void setImage2(byte[] image2) {
        this.image2 = image2;
    }

    public byte[] getImage3() {
        return image3;
    }

    public void setImage3(byte[] image3) {
        this.image3 = image3;
    }

    public BigInteger getPrece() {
        return Prece;
    }

    public void setPrece(BigInteger prece) {
        Prece = prece;
    }

    public BigInteger getStock() {
        return Stock;
    }

    public void setStock(BigInteger stock) {
        Stock = stock;
    }



    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getProductDesc(){
        return productDesc;
    }

    public void setProductDesc(String productDesc){
        this.productDesc = productDesc;
    }

    public byte[] getImage1() {
        return image1;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }
}
