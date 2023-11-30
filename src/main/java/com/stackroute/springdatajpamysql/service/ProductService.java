
package com.stackroute.springdatajpamysql.service;

import com.stackroute.springdatajpamysql.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int productId);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    String deleteProduct(int productId);

    List<Product> getAllProductsHavingPriceLessThan(double price);
}

