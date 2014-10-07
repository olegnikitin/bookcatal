package com.bookcatalogue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by яна on 27.09.14.
 */
@Controller
public class StartController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/main_page";
    }

    @RequestMapping("/main_page")
    public String main_page(){
        return "main_page";
    }
}
