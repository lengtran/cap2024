package com.lengper.cap2024.controller;

import com.lengper.cap2024.database.OrderDAO;
import com.lengper.cap2024.database.OrderDetailDAO;
import com.lengper.cap2024.database.ProductDAO;
import com.lengper.cap2024.entity.Order;
import com.lengper.cap2024.entity.OrderDetail;
import com.lengper.cap2024.entity.Product;
import com.lengper.cap2024.entity.User;
import com.lengper.cap2024.security.AuthenticatedUserUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;



@Slf4j // used for logging. fancy system.out.println
@Controller // figures out what html file that's needed
public class OrderController {


    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @Autowired
    private ProductDAO productDAO;


//    @GetMapping("/location") // sets the url that the page is listening for. once url is added to the end of the url this function will run
//    public ModelAndView location() {
//        ModelAndView response = new ModelAndView("locations/locations"); // file structure inside the project
//        // add stuff here to make page dynamic (adds db data to page)
//
//        return response;
//    }

    @GetMapping("/order/orderdetail")
    public ModelAndView orderDetail(@RequestParam Integer orderId) {
        ModelAndView response = new ModelAndView("order/orderdetail");

        User user = authenticatedUserUtilities.getCurrentUser(); //gets the authenticated user...

        Order order = orderDAO.findByIdAndUserId(orderId, user.getUserId()); //this basically ensures that the user has otder associated with it

        if ( order!= null){ //basically checks if the order is not empty it then generates the details for that order....
            List<Map<String, Object>> orderDetails = orderDAO.getOrderDetails(order.getId());
            response.addObject("orderDetails", orderDetails);

            Double orderTotal = orderDAO.getOrderTotal(order.getId());
            response.addObject("orderTotal", orderTotal);

        } else {
            response.addObject("error", "Order is not found");
            return new ModelAndView("redirect:/error/404");
        }


        return response;
    }

    @GetMapping("/order/addToCart")
    public ModelAndView addToCart(@RequestParam Integer productId){
        ModelAndView response = new ModelAndView();

        Product product = productDAO.findById(productId);
        User user = authenticatedUserUtilities.getCurrentUser();
        // now we need to get the order from the database where the status is 'CART' and the user is the logged in user

        // Find the order with status "CART" for the current user
        Order order = orderDAO.findOrderInCartStatus(user.getUserId());
        if (order == null) {
            // If no such order exists, create a new one
            order = new Order();
            order.setUser(user);
            order.setOrderDate(new Date()); // Set the order date to now
            order.setStatus(("CART")); //newly addeed........
            orderDAO.save(order);
        }

        // Check if the product is already in the cart
        OrderDetail orderDetail = orderDetailDAO.findByOrderAndProduct(order.getId(), product.getId());
        if (orderDetail == null) {
            // If the product is not in the cart, add it
            orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(product);
            orderDetail.setQty(1); // Start with a quantity of 1
            orderDetailDAO.save(orderDetail);
        } else {
            // If the product is already in the cart, update the quantity
            orderDetail.setQty(orderDetail.getQty() + 1);
            orderDetailDAO.save(orderDetail);
        }

        response.setViewName("redirect:/order/orderdetail");
        return response;



    }






}
