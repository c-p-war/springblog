package com.codeup.springblog.models;
import javax.persistence.*;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String name;
}
