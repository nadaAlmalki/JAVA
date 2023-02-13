package com.example.week6_hw27.Service;

import com.example.week6_hw27.ApiException;
import com.example.week6_hw27.Model.Blog;
import com.example.week6_hw27.Repository.Blog_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class Blog_Service {
    
    private final Blog_Repository blog_repository;
    public List<Blog> getBlogs() {
        return blog_repository.findAll();
    }

    public void addBlogs(Blog blog) {
        blog_repository.save(blog);
    }

    public void updateBlogs(Integer id, Blog blogs) {
        Blog blog = blog_repository.findBlogById(id);
        if (blog == null) {
            throw new ApiException("Blog not found");
        }
        blog.setTitle(blogs.getTitle());
        blog.setBody(blogs.getBody());
        blog_repository.save(blog);
    }

    public void deleteBlog(Integer id) {
        Blog Blog = blog_repository.findBlogById(id);
        if (Blog == null) {
            throw new ApiException("Blog not found");
        }
        blog_repository.delete(Blog);
    }

        //Get blog by Id
    public Blog getBlogById(Integer id) {
        Blog blog = blog_repository.findBlogById(id);
        if(blog == null && blog.getId()!=id){
            throw new ApiException("Incorrect ID");

        }
        return blog;
    }

        //Get blog by title
    public Blog getBlogByTitle(String title){
        Blog blog = blog_repository.findBlogByTitle(title);
        if(blog == null){
            throw new ApiException("Incorrect Input");
        }
        return blog;
    }


}
