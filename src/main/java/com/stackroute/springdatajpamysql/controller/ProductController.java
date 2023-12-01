package com.stackroute.springdatajpamysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.service.ProductService;

@Controller
@RequestMapping("/api")

public class ProductController {
    // Add controllers here for CRUD operations on Product entity.
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
 
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts(); // Call service interface method
        return ResponseEntity.ok(products);
    }
    @GetMapping("/products/{price}")
    public ResponseEntity<List<Product>> getAllProductsHavingPriceLessThan(@PathVariable double price) {
        List<Product> products = productService.getAllProductsHavingPriceLessThan(price); // Call service interface method
        return ResponseEntity.ok(products);
    }
    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        Product product = productService.getProductById(id); // Call service interface method
        return ResponseEntity.ok(product);
    }
    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.saveProduct(product));
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id) {
        productService.deleteProduct(id); // Call service interface method
        return ResponseEntity.ok("Product Deleted");
    }
    @PutMapping("products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable long id ){
        return ResponseEntity.ok(productService.updateProduct(product, id));
    }
}



