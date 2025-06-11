package it.epicode.U5_W2_D2Pratica.controller;

import it.epicode.U5_W2_D2Pratica.dto.BlogPostDto;
import it.epicode.U5_W2_D2Pratica.exception.NotFoundException;
import it.epicode.U5_W2_D2Pratica.model.BlogPost;
import it.epicode.U5_W2_D2Pratica.repository.AutoreRepository;
import it.epicode.U5_W2_D2Pratica.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogpost")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    AutoreRepository autoreRepository;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody BlogPostDto blogPostDto) throws NotFoundException {
        return blogPostService.saveBlogPost(blogPostDto);
    }

    @GetMapping("{id}")
    public BlogPost getBlogPost(@PathVariable int id) throws NotFoundException{
        return blogPostService.getBlogPost(id);
    }

    @GetMapping("")
    public List<BlogPost> getAllBlogPost(){
        return blogPostService.getAllBlogPost();
    }

    @PutMapping("{id}")
    public BlogPost updateBlogPost(@PathVariable int id,@RequestBody BlogPostDto blogPostDto) throws NotFoundException{
        return blogPostService.updateBlogPost(id, blogPostDto);
    }

    @DeleteMapping("{id}")
    public void deleteBlogPost(@PathVariable int id) throws NotFoundException{
        blogPostService.deleteBlogPost(id);
    }
}
