package it.epicode.U5_W2_D2Pratica.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Autore {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String avatar;
}
