package com.codeup.springblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.codeup.springblog.models.Post;


//Long because of post ID?
public interface PostRepository extends JpaRepository <Post, Long>{

    //JPA queries
    Post findByTitle(String title);

}
