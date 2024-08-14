package com.lengper.cap2024.controller;

import com.lengper.cap2024.database.ProductDAO;
import com.lengper.cap2024.entity.Product;
import com.lengper.cap2024.form.CreateProductFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView products2(@PathVariable("id") Integer id) {
        ModelAndView response = new ModelAndView("productDetails/productDetails"); // file structure inside the project
        // add stuff here to make page dynamic (adds db data to page)
        Product product = productDAO.getProductById(id);
        response.addObject("product", product);
        return response;
    }
// this is my fault lol this is commeneted out because i moved it to admin controller NOTE TO SELF
//    //this is for the product create page....
    @GetMapping("/create")
    public ModelAndView createProduct() {
        ModelAndView response = new ModelAndView("products/create");
        response.addObject("createProductFormBean", new CreateProductFormBean());
        return response;
    }


    // this is for creating a product --------------- we should add an edit feature....
    @PostMapping("/products/create")
    public ModelAndView createProductSubmit(@Valid CreateProductFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("products/create");

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


    // this is going to be for the search product, we will put a lambda here!!!
    @GetMapping("/products/search")
    public ModelAndView searchProducts(@RequestParam(required = false) String search) { //is this red for you????
        ModelAndView response = new ModelAndView("products/products");
        log.debug("The user searched for product: " + search);
        List<Product> products = productDAO.findByName(search);

        products.stream().forEach(product -> log.debug("Product" + product.getName())); // this LAand stream function for the requirement,
        
        response.addObject("products", products);
        response.addObject("search", search); //this is if we want to see what the user submited after they submitted
        return response;
    }


}
