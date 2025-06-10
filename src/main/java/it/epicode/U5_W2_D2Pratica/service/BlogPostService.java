package it.epicode.U5_W2_D2Pratica.service;

import it.epicode.U5_W2_D2Pratica.exception.BlogPostNotFoundException;
import it.epicode.U5_W2_D2Pratica.model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> blogPost = new ArrayList<>();

    public BlogPost saveBlogPost(BlogPost blogPosts){
        blogPosts.setId(new Random().nextInt(1,500));
        blogPosts.setCover("https://picsum.photos/200/300");
        blogPost.add(blogPosts);
        return blogPosts;
    }

    public BlogPost getBlogPost(int id) throws BlogPostNotFoundException {
        return blogPost.stream().filter(blogPost -> blogPost.getId()==id)
                .findFirst().orElseThrow(() -> new BlogPostNotFoundException("Non esiste un post con questo id " + id));
    }

    public List<BlogPost> getAllBlogPost(){
        return blogPost;
    }

    public BlogPost updateBlogPost(int id, BlogPost blogPost) throws BlogPostNotFoundException {
        BlogPost postDaCercare = getBlogPost(id);
        postDaCercare.setCategoria(blogPost.getCategoria());
        postDaCercare.setTitolo(blogPost.getTitolo());
        postDaCercare.setContenuto(blogPost.getContenuto());
        postDaCercare.setTempoDiLettura(blogPost.getTempoDiLettura());
        return postDaCercare;
    }

    public void deleteBlogPost(int id) throws BlogPostNotFoundException {
        BlogPost blogPostDaRimuovere = getBlogPost(id);
        blogPost.remove(blogPostDaRimuovere);
    }

}
