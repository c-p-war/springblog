package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello from Spring!";
    }


    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello " + name + "!";
    }

//    @GetMapping("/home/{name}")
//    public String sayHello(@PathVariable String name, Model model){
//        model.addAttribute("name", name);
//        return "hello";
//    }

    //can be a get or a post must indicate path, get by default
    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    //statically typed must specify type of parameter we are passing in
    //should return the number (from url) plus one (html rendered)
    public String addOne(@PathVariable int number){
        return number + " plus one is " + (number + 1) + "!";
    }
}
