package com.lengper.cap2024.controller;

import com.lengper.cap2024.database.ProductDAO;
import com.lengper.cap2024.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Slf4j // used for logging. fancy system.out.println
@Controller // figures out what html file that's needed
public class ProductController {


    @Autowired
    private ProductDAO productDAO;

    //this will be for listing the products on the page ---------------------
    @GetMapping("/products")
    public ModelAndView products() {
        ModelAndView response = new ModelAndView("products/products");
        List<Product> products = productDAO.findAllProducts();
        response.addObject("products", products);
        return response;
    }


    // this will be for the products detail page  -------------
    @GetMapping("/products/{id}") // sets the url that the page is listening for. once url is added to the end of the url this function will run
    public ModelAndView products2() {
        ModelAndView response = new ModelAndView("products/products"); // file structure inside the project
        // add stuff here to make page dynamic (adds db data to page)

        return response;
    }


}
