
package com.stackroute.springdatajpamysql.service;

import com.stackroute.springdatajpamysql.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    //Add abstract methods here
    List<Product> getAllProducts();
    List<Product> getAllProductsHavingPriceLessThan(double price);
    Product getProductById(long id);
    Product saveProduct(Product product);
    Product updateProduct(Product product, long id);
    String deleteProduct(long id);
}

