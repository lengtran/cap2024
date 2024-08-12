package com.lengper.cap2024.database;

import com.lengper.cap2024.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {

    @Query("SELECT od FROM OrderDetail od WHERE od.order.id = :orderId AND od.product.id = :productId")
    OrderDetail findByOrderAndProduct(@Param("orderId") Integer orderId, @Param("productId") Integer productId);

//    OrderDetail findById(Integer id);
    //@Query(value = "select * from orderdetails where order_id = :orderId and product_id = :productId", nativeQuery = true)
    //    OrderDetail isProductInCart(Integer orderId, Integer productId); this was the class one...... remove later

}
