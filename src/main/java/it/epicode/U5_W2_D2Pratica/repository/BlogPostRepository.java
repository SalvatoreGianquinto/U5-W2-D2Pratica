package it.epicode.U5_W2_D2Pratica.repository;

import it.epicode.U5_W2_D2Pratica.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {
}
