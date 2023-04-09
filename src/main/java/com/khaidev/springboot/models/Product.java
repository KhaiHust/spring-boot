package com.khaidev.springboot.models;

import jakarta.persistence.*;

//POJO = Plain Object Java Object
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "year1")
    private int year1;
    @Column(name = "price")
    private Double price;
    @Column(name = "url")
    private String url;

    public Product() {
    }

    public Product(String productName, int year1, Double price, String url) {

        this.productName = productName;
        this.year1 = year1;
        this.price = price;
        this.url = url;
    }
    //POJO object

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", year=" + year1 +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
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

    public int getYear() {
        return year1;
    }

    public void setYear(int year1) {
        this.year1 = year1;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
