package com.bookcatalogue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by яна on 27.09.14.
 */
@Controller
@RequestMapping("/")
public class StartController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "redirect:/main_page";
    }

    @RequestMapping("/main_page")
    public String main_page(){
        return "main_page";
    }
}
