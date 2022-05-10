package com.example.demo.products;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private long id;
    private String productName;
    private String category;
    private Double price;
    private String comment;
    private String freshness;
    private LocalDate date;

    public Product() {
    }

    public Product(long id, String productName, String category, Double price, String comment, String freshness, LocalDate date) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.comment = comment;
        this.freshness = freshness;
        this.date = date;
    }

    public Product(String productName, String category, Double price, String comment, String freshness, LocalDate date) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.comment = comment;
        this.freshness = freshness;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFreshness() {
        return freshness;
    }

    public void setFreshness(String freshness) {
        this.freshness = freshness;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                ", freshness='" + freshness + '\'' +
                ", date=" + date +
                '}';
    }
}
