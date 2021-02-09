package com.codeup.springblog.controllers;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;




@Controller
public class PostController {

    //Get  === /post         === posts index page
    @RequestMapping(path = "/post", method = RequestMethod.GET)
    @ResponseBody
    public String posts(){
        return "Posts index page";
    }

    //Get  === /posts/{id}   === view and individual post
    @RequestMapping(path = "/post/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postById(@PathVariable int id){
        return "view an individual post" + "<br>" + "post id is: " + id;
    }

    //Get  === /posts/create === view the form for creating a post
    @RequestMapping(path = "/post/create", method = RequestMethod.GET)
    @ResponseBody
    public String postWrite(){
        return "Write a post (form goes here X)";
    }

    //POST === /posts/create === create a new post
    @RequestMapping(path = "/post/create", method = RequestMethod.POST)
    @ResponseBody
    public String postSubmit(){
        return "Create/Submit post";
    }

}
