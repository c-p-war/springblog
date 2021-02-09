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

    //defeining a path variable
    //will evaluate whats in brackets after name
    @GetMapping("/hello/{name}")
    @ResponseBody

    //the path variable allows me to do /hello/caleb and it will return Hello Caleb! on the html
    public String sayHello(@PathVariable String name){
        return "Hello " + name + "!";
    }



    //can be a get or a post must indiciate path, get by default
    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    //statically typed must specify type of parameter we are passing in
    //should return the number (from url) plus one (html rendered)
    public String addOne(@PathVariable int number){
        return number + " plus one is " + (number + 1) + "!";
    }
}
