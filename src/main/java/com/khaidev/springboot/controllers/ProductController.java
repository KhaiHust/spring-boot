package com.khaidev.springboot.controllers;

import com.khaidev.springboot.models.Product;
import com.khaidev.springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    @Autowired
    private ProductRepository repository;
    @GetMapping("")
    List<Product> getAllProduct(){
        return repository.findAll();
//        return List.of(
//                new Products(1L, "Macbook pro 16",2020, 2400.0,""),
//                new Products(2L, "ipad gen 9",2021, 399.0,"")
//        );
    }
}
