package com.khaidev.springboot.database;

import com.khaidev.springboot.models.Product;
import com.khaidev.springboot.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDataBase(ProductRepository productRepository){

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                //logger

                Product productA;
                productA = new Product("Macbook pro 16",2020, 2400.0,"");
                Product productB = new Product("ipad gen 9",2021, 399.0,"");

                logger.info("insert data :" + productRepository.saveAndFlush(productA));
                logger.info("insert data :" + productRepository.saveAndFlush(productB));
            }
        };
    }

}
