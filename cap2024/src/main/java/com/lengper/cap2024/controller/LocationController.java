package com.lengper.cap2024.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Slf4j // used for logging. fancy system.out.println
@Controller // figures out what html file that's needed
public class LocationController {

    @GetMapping("/location") // sets the url that the page is listening for. once url is added to the end of the url this function will run
    public ModelAndView location() {
        ModelAndView response = new ModelAndView("locations/locations"); // file structure inside the project
        // add stuff here to make page dynamic (adds db data to page)

        return response;
    }


}
