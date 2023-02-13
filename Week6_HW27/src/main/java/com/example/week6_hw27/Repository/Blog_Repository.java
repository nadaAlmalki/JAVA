package com.example.week6_hw27.Repository;

import com.example.week6_hw27.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Blog_Repository extends JpaRepository<Blog, Integer> {

    Blog findBlogById(Integer id);
    Blog findBlogByTitle(String title);
}
