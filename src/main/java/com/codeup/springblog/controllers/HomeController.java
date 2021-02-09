package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//might need the response body import

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String landing(){
        return "This is the landing page!";
    }
}
