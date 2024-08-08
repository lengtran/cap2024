package com.lengper.cap2024.database;

import com.lengper.cap2024.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {

    Product getProductById(Integer id);

    @Query("SELECT p FROM Product p")
    List<Product> findAllProducts();

    // this query is for the search function on our products page....

    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :name, '%')")
    List<Product> findByName(String name);
}