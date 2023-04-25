package com.example.demo.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Category {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory_Name() {
        return Category_Name;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }

    public String getCategory_Image() {
        return Category_Image;
    }

    public void setCategory_Image(String category_Image) {
        Category_Image = category_Image;
    }

    public String getCategory_Description() {
        return Category_Description;
    }

    public void setCategory_Description(String category_Description) {
        Category_Description = category_Description;
    }

    @Id
    private Long id;
    private String Category_Name;
    private String Category_Image;
    private String Category_Description;

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    @ManyToOne
    @JoinColumn(name="Category_id")
    private Product product;
}
