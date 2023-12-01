package com.stackroute.springdatajpamysql.repository;





import com.stackroute.springdatajpamysql.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT product FROM Product p WHERE p.price < :price")
    List<Product> findProductsLessThanPrice(@Param("price") Double price);
}
