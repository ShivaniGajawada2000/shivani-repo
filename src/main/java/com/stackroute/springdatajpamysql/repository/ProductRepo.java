package com.stackroute.springdatajpamysql.repository;





import com.stackroute.springdatajpamysql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    // Add custom query methods if needed
    List<Product> findByProductPriceLessThan(double price);
}
