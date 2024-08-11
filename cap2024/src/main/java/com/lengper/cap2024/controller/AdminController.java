package com.lengper.cap2024.controller;

import com.lengper.cap2024.database.ProductDAO;
import com.lengper.cap2024.database.UserDAO;
import com.lengper.cap2024.entity.Product;
import com.lengper.cap2024.entity.User;
import com.lengper.cap2024.form.CreateProductFormBean;
import com.lengper.cap2024.security.AuthenticatedUserUtilities;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')") //must use in case study!! this has to match what we put in the database!!!

public class AdminController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @GetMapping("/products") //this will be for editing the products page, mostly just displaying this stuff ...
    public ModelAndView product() {
        ModelAndView response = new ModelAndView("admin/editProducts");

        User user = authenticatedUserUtilities.getCurrentUser();
        log.debug(user.toString()); //this is just to meet the log requirements....

        response.addObject("products", productDAO.findAll());
        return response;
    }

// this will delete the actual product from the db, BE CAREFUL USING THISSS!!!!

    @PostMapping("/deleteProduct") //this is for deleting products
    public ModelAndView deleteProduct(@RequestParam Integer productId) {
        ModelAndView response = new ModelAndView("redirect:/admin/products"); //this is for mapping

        Product product = productDAO.findById(productId);
        if (product != null) {
            productDAO.delete(product);
        } else {
            response.addObject("errorMessage", "Product not found.");
        }

        return response;
    }


// Amber used create jsp as well as the hidden id


    @GetMapping("/editProduct")//This will be for the edit products.....
    public ModelAndView editProduct(@RequestParam Integer productId){

        ModelAndView response= new ModelAndView("admin/editProducts");
        Product product = productDAO.findById(productId);
        if (product != null) {
            response.addObject("product", product);
        } else {
            response.setViewName("redirect:/admin/products");
            response.addObject("errorMessage", "Product not found.");
        }

        return response;

    }


// --------------------this is what was given from the product controller we are just moving it into the admin controller    //this is for the product create page....

    @GetMapping("/create")
    public ModelAndView createProduct() {
        ModelAndView response = new ModelAndView("admin/create");
        response.addObject("createProductFormBean", new CreateProductFormBean());
        return response;
    }


    // this is for creating a product --------------- we should add an edit feature....
    @PostMapping("/products/create")
    public ModelAndView createProductSubmit(@Valid CreateProductFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("admin/create");

        if (bindingResult.hasErrors()) {
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            return response;
        }

        Product product = new Product();
        product.setName(form.getName());
        product.setPrice(form.getPrice());
        product.setImage(form.getImage());
        product.setDescription(form.getDescription());

        productDAO.save(product);

        return response;
    }









//    @GetMapping("/admin")
//    public ModelAndView location() {
//        ModelAndView response = new ModelAndView("admin/location");
//
//        return response;
//    }





}
