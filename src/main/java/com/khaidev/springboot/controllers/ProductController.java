package com.khaidev.springboot.controllers;

import com.khaidev.springboot.models.Product;
import com.khaidev.springboot.models.ResponseObject;
import com.khaidev.springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> getProductbyId(@PathVariable Long id){
        Optional<Product> foundProduct = repository.findById(id);
        return foundProduct.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false", "Can not find product with id " + id, "")
        ) : ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query product success", foundProduct)
        );

    }
    //insert new Product with POST method
    //POSTMan: RAW/ JSON
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct){
        List<Product> foundProduct = repository.findByProductName(newProduct.getProductName().trim());
        return foundProduct.size() > 0 ? ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("false", "product " + newProduct.getProductName() + " already ", "")
        ):
       ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject("ok", "insert product successfully", repository.save(newProduct))
        );
    }
    //update, insert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long id){
        Product updatedProduct = repository.findById(id)
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setPrice(newProduct.getPrice());
                    product.setYear(newProduct.getYear());
                    product.setUrl(newProduct.getUrl());
                    return repository.save(product);
                }).orElseGet(()->{
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update product successfully", repository.save(updatedProduct))
        );
    }
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id){
        boolean exist = repository.existsById(id);
        repository.deleteById(id);
        return exist ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "delete product successfully","")
        ):ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false", "Can not find product to delete","")
        );
    }
}
