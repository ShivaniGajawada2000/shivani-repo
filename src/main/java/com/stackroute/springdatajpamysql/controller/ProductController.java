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
	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }

	    @GetMapping("/products")
	    public ResponseEntity<List<Product>> getAllProducts() {
	        List<Product> products = productService.getAllProducts();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @GetMapping("/{productId}")
	    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
	        Product product = productService.getProductById(productId);
	        
	        return new ResponseEntity<>(product, HttpStatus.OK);
	        
	    }
	   

	    @PostMapping("/product")
	    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
	        Product savedProduct = productService.saveProduct(product);
	        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	    }

	      
	    @PutMapping("/product")
	    public ResponseEntity<Product> updateProduct( @RequestBody Product product) {
	        Product updatedProduct = productService.updateProduct(product);
	        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	    }
	    

	    @DeleteMapping("/{productId}")
	    public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
	        String s=productService.deleteProduct(productId);
	        return new ResponseEntity<>(s,HttpStatus.OK);
	    }

	    @GetMapping("/priceLessThan/{price}")
	    public ResponseEntity<List<Product>> getAllProductsHavingPriceLessThan(@PathVariable double price) {
	        List<Product> products = productService.getAllProductsHavingPriceLessThan(price);
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }
	}
	



