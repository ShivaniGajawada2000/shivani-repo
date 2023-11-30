package com.stackroute.springdatajpamysql.service;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.repository.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

	private final ProductRepo productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) {
        Optional <Product> product=productRepository.findById(productId);
        return product.orElse(null);
    }
    

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
    	Optional<Product> optionalProduct= productRepository.findById(product.getProductId());
        if (optionalProduct.isPresent()) {
           
            Product existingProduct = optionalProduct.get();
            existingProduct.setProductName(product.getProductName());
            existingProduct.setProductPrice(product.getProductPrice());
            
            return productRepository.save(existingProduct);
        } else {
            
            return null;
        }
      
    }

    @Override
    public String deleteProduct(int productId) {
        
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return "Product deleted successfully";
        } else {
            return "Product not found";
        }
    }

    @Override
    public List<Product> getAllProductsHavingPriceLessThan(double price) {
        return productRepository.findByProductPriceLessThan(price);
    }
}
