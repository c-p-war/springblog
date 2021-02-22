package com.codeup.springblog.models;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false, unique = true)
    private String password;

    //constructor
    public User(){}

    //basic user format
    public User(long id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //getters and setters

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id=id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    //getters and setters for posts by user
    public List<Post> getPosts(){
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    //One user has many posts
@OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Post> posts;


}


