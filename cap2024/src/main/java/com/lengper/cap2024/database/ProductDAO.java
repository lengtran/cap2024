package database;

import entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {

//    Product findById(Integer id); //details page which will take in the id for the specific product

    @Query("SELECT p FROM Product p")
    List<Product> findAllProducts();

//    @Query("select p from Product p where p.productName like concat('%', :name, '%')")
//    List<Product> findByName(String name); //this is for search button
}