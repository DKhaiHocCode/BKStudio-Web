package com.bkstudio.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private int stockQuantity;
    private String resinType;
    private String scale;
    private String imageUrl;

    // --- GETTERS ---

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getResinType() {
        return resinType;
    }

    public String getScale() {
        return scale;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    // --- SETTERS ---

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setResinType(String resinType) {
        this.resinType = resinType;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
