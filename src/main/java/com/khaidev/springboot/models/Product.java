package com.khaidev.springboot.models;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Objects;

//POJO = Plain Object Java Object
@Entity
@Table(name = "tblProduct")
public class Product {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sqquence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(name = "id")
    private long id;
    @Column(name = "product_name", nullable = false, unique = true, length = 300)
    private String productName;
    @Column(name = "year1")
    private int year1;
    @Column(name = "price")
    private Double price;
    @Column(name = "url")
    private String url;
    //calculated field = transient
    @Transient
    private int age;//

    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - year1;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && year1 == product.year1 && Objects.equals(productName, product.productName) && Objects.equals(price, product.price) && Objects.equals(url, product.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, year1, price, url);
    }
}
