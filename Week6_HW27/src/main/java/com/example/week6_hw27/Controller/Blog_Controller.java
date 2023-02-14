package com.example.week6_hw27.Controller;

import com.example.week6_hw27.Model.Blog;
import com.example.week6_hw27.Service.Blog_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/blog")
@RestController
@RequiredArgsConstructor
public class Blog_Controller {

    private final Blog_Service blog_service;

    @GetMapping("/get")
    public ResponseEntity getBlog() {
        List<Blog> blogs = blog_service.getBlogs();
        return ResponseEntity.status(200).body(blogs);
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog){
        blog_service.addBlogs(blog);
        return ResponseEntity.status(200).body("Blogs added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@PathVariable Integer id, @Valid @RequestBody Blog blog){
        blog_service.updateBlogs(id, blog);
        return ResponseEntity.status(200).body("Blogs updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id){

        blog_service.deleteBlog(id);

        return ResponseEntity.status(200).body("Blogs Deleted");
    }
    //Get blog by Id
    @GetMapping("/blogid/{id}")
    public ResponseEntity findByBlogId(@PathVariable Integer id){
        Blog blog = blog_service.getBlogById(id);
        return ResponseEntity.status(200).body(blog);
    }

    //Get blog by title
    @GetMapping("/blogtitle/{title}")
    public ResponseEntity findByBlogTitle(@PathVariable String title){
        Blog blog=blog_service.getBlogByTitle(title);
        return ResponseEntity.status(200).body(blog);
    }

}
