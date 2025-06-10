package it.epicode.U5_W2_D2Pratica.controller;

import it.epicode.U5_W2_D2Pratica.exception.BlogPostNotFoundException;
import it.epicode.U5_W2_D2Pratica.model.Autore;
import it.epicode.U5_W2_D2Pratica.model.BlogPost;
import it.epicode.U5_W2_D2Pratica.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/blogpost")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody BlogPost blogPost){
        return blogPostService.saveBlogPost(blogPost);
    }

    @GetMapping("/blogpost/{id}")
    public BlogPost getBlogPost(@PathVariable int id) throws BlogPostNotFoundException{
        return blogPostService.getBlogPost(id);
    }

    @GetMapping("/blogpost")
    public List<BlogPost> getAllBlogPost(){
        return blogPostService.getAllBlogPost();
    }

    @PutMapping("/blogpost/{id}")
    public BlogPost updateBlogPost(@PathVariable int id,@RequestBody BlogPost blogPost) throws BlogPostNotFoundException{
        return blogPostService.updateBlogPost(id, blogPost);
    }

    @DeleteMapping("/blogpost/{id}")
    public void deleteBlogPost(@PathVariable int id) throws BlogPostNotFoundException{
        blogPostService.deleteBlogPost(id);
    }
}
