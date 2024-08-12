package com.lengper.cap2024.database;

import com.lengper.cap2024.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface OrderDAO extends JpaRepository<Order, Integer> { //import this please!!

// this is going to retrieve order details, fufills one of the requirements
// Added order detail id to map, this could break things later.
    @Query(value = "SELECT o.id AS order_id, o.order_date, p.name AS product_name, od.qty AS quantity_ordered, " +
            "p.price AS product_price, (od.qty * p.price) AS line_item_total, p.id AS product_id " +
            "FROM order_details od " +
            "JOIN products p ON od.product_id = p.id " +
            "JOIN orders o ON od.order_id = o.id " +
            "WHERE o.id = :orderId " +
            "ORDER BY o.id", nativeQuery = true)
    List<Map<String, Object>> getOrderDetails(@Param("orderId") Integer orderId);


    @Query(value = "SELECT * FROM orders WHERE user_id = :userId AND status = 'CART'", nativeQuery = true)
    Order findOrderInCartStatus(@Param("userId") Integer userId);

    @Query("SELECT o FROM Order o WHERE o.id = :orderId AND o.user.userId = :userId")
    Order findByIdAndUserId(@Param("orderId") Integer orderId, @Param("userId") Integer userId); //this is the query

    @Query("SELECT SUM(od.qty * p.price) FROM OrderDetail od JOIN od.product p WHERE od.order.id = :orderId")
    Double getOrderTotal(@Param("orderId") Integer orderId);


}
