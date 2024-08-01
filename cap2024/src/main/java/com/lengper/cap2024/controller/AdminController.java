package com.lengper.cap2024.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/admin")

public class AdminController {

    @GetMapping("/admin")
    public ModelAndView product() {
        ModelAndView response = new ModelAndView("admin/product");

        return response;
    }

//    @GetMapping("/admin")
//    public ModelAndView location() {
//        ModelAndView response = new ModelAndView("admin/location");
//
//        return response;
//    }



}
