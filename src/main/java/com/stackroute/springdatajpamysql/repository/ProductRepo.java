package com.stackroute.springdatajpamysql.repository;





import com.stackroute.springdatajpamysql.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    
    List<Product> findProductsLessThanPrice(double price);
}
