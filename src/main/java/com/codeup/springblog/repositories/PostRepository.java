package com.codeup.springblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.codeup.springblog.models.Post;



public interface PostRepository extends JpaRepository <Post, Long>{
}
