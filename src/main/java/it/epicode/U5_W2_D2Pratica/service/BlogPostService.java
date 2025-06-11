package it.epicode.U5_W2_D2Pratica.service;

import it.epicode.U5_W2_D2Pratica.dto.BlogPostDto;
import it.epicode.U5_W2_D2Pratica.exception.NotFoundException;
import it.epicode.U5_W2_D2Pratica.model.Autore;
import it.epicode.U5_W2_D2Pratica.model.BlogPost;
import it.epicode.U5_W2_D2Pratica.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private AutoreService autoreService;

    public BlogPost saveBlogPost(BlogPostDto blogPostsDto) throws NotFoundException {
        Autore autore = autoreService.getAutore(blogPostsDto.getAutoreId());
        BlogPost blogPosts = new BlogPost();
        blogPosts.setCategoria(blogPostsDto.getCategoria());
        blogPosts.setTitolo(blogPostsDto.getTitolo());
        blogPosts.setContenuto(blogPostsDto.getContenuto());
        blogPosts.setTempoDiLettura(blogPostsDto.getTempoDiLettura());
        blogPosts.setAutore(autore);
        blogPosts.setCover("https://picsum.photos/200/300");
        return blogPostRepository.save(blogPosts);
    }

    public BlogPost getBlogPost(int id) throws NotFoundException {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Non esiste un post con questo id " + id));
    }

    public List<BlogPost> getAllBlogPost(){
        return blogPostRepository.findAll();
    }

    public BlogPost updateBlogPost(int id, BlogPostDto blogPostDto) throws NotFoundException {
        BlogPost blogPostDaAggiornare = getBlogPost(id);
        blogPostDaAggiornare.setCategoria(blogPostDto.getCategoria());
        blogPostDaAggiornare.setTitolo(blogPostDto.getTitolo());
        blogPostDaAggiornare.setContenuto(blogPostDto.getContenuto());
        blogPostDaAggiornare.setTempoDiLettura(blogPostDto.getTempoDiLettura());

        if (blogPostDto.getAutoreId()!=blogPostDaAggiornare.getAutore().getId()) {
            Autore autore = autoreService.getAutore(blogPostDto.getAutoreId());
            blogPostDaAggiornare.setAutore(autore);
        }

        return blogPostRepository.save(blogPostDaAggiornare);
    }

    public void deleteBlogPost(int id) throws NotFoundException {
        BlogPost blogPostDaRimuovere = getBlogPost(id);
        blogPostRepository.delete(blogPostDaRimuovere);
    }

}
