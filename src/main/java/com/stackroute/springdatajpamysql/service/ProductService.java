package com.stackroute.springdatajpamysql.service;

import com.stackroute.springdatajpamysql.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    List<Product> getAllProductsHavingPriceLessThan(double price);

    Product getProductById(Long id);

    Product saveProduct(Product product);

    Product updateProduct(Product updatedProduct, Long id);

    String deleteProduct(Long id);
}
