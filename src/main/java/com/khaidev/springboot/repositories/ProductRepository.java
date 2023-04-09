package com.khaidev.springboot.repositories;

import com.khaidev.springboot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
