
package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, length = 240)
    private String password;

    @Column(nullable = false, length = 240)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(){

    }

    public User(User copy) {
        this.id = copy.id;
        this.email = copy.email;
        this.password = copy.password;
        this.username = copy.username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

