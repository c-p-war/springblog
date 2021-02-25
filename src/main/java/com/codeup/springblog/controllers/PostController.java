
package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    //Dependency injections
    private final PostRepository postsDao;
    private final UserRepository usersDao;

    //Nec. construct
    public PostController (PostRepository postsDao, UserRepository usersDao){
        this.postsDao = postsDao;
        this.usersDao = usersDao;
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
    public String updatePost(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
        Post post = new Post(
                id,
                title,
                body
        );
        postsDao.save(post);
        return "redirect:/posts";
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
    public String createPost(@RequestParam String title, @RequestParam String body){
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);

        //Needs user in DB
        User user = usersDao.findAll().get(0);
        //getting and setting user who created post
        post.setUser(user);

        postsDao.save(post);
        return "redirect:/posts/"+post.getId();
    }
}
