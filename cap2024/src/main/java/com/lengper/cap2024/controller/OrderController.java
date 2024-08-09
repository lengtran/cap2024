package com.lengper.cap2024.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Slf4j // used for logging. fancy system.out.println
@Controller // figures out what html file that's needed
public class OrderController {

//    @GetMapping("/location") // sets the url that the page is listening for. once url is added to the end of the url this function will run
//    public ModelAndView location() {
//        ModelAndView response = new ModelAndView("locations/locations"); // file structure inside the project
//        // add stuff here to make page dynamic (adds db data to page)
//
//        return response;
//    }

    @GetMapping("/order/orderdetail") //going to use this to modify the items that are going to be in your cart
    public ModelAndView orderDetail(@RequestParam Integer orderId) {
        ModelAndView response = new ModelAndView("order/orderdetail");

        List<Map<String,Object>> orderDetails = orderDao.getOrderDetails(orderId);
        response.addObject("orderDetails", orderDetails);

        return response;
    }


    @GetMapping("/order/addToCart")



}
