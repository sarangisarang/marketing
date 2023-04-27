package com.example.demo.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Category {
    @Id
    private Long Category_id;
    private String Category_Name;
    private String Category_Image;
    private String Category_Description;


    public Long getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(Long category_id) {
        Category_id = category_id;
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
}
