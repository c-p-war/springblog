
package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    //Dependency injections
    private final PostRepository postsDao;

    //Nec. construct
    public PostController (PostRepository postsDao){
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model){
        model.addAttribute("posts", postsDao.findAll());

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postView(Model model, @PathVariable long id) {
        Post post = postsDao.getOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String vieweditPostForm(@PathVariable long id, Model model){
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    ////////////////////////////////////////////////////////
    //Edit and delete using post mapping for forms (posts)//
    ////////////////////////////////////////////////////////
    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @RequestParam String title, @RequestParam String body){
        Post postToChange = postsDao.getOne(id);
        postToChange.setTitle(title);
        postToChange.setBody(body);
        postsDao.save(postToChange);
        return "redirect:/posts/" +id;
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        System.out.println("Removing post");
        postsDao.deleteById(id);
        //////////////////////////////////////////////////
        //Is this part of spring? Or simply a template? //
        /////////////////////////////////////////////////
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postForm(){
        return "Create a post here!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Creating a new post...";
    }




}
