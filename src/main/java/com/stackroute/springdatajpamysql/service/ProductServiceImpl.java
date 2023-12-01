package com.stackroute.springdatajpamysql.service;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.repository.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl  implements ProductService  {
    //Override all the methods here
 
    @Autowired
    private ProductRepo productRepo;
 
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    @Override
    public List<Product> getAllProductsHavingPriceLessThan(double price) {
        return productRepo.findProductsLessThanPrice(price);
    }
 
 
 
    @Override
    public Product getProductById(long id) {
        return productRepo.findById(id).orElse(null);
    }
    public Product saveProduct(Product product) {
        return productRepo.save(product);
 
    }
    @Override
    public Product updateProduct(Product product, long id) {
        Optional<Product> product1 = productRepo.findById(product.getProductId());
        if(product1.isPresent()) {
            Product tempProd = product1.get();
            tempProd.setName(product.getName());
            tempProd.setPrice(product.getPrice());
            return productRepo.save(tempProd);
        }
        return null;
    }
    @Override
    public String deleteProduct(long id) {
        productRepo.deleteById(id);
        return "Product Deleted";
    }
}
