package it.epicode.U5_W2_D2Pratica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Autore {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String avatar;

    @JsonIgnore
    @OneToMany(mappedBy = "autore")
    private List<BlogPost> blogPost;
}
