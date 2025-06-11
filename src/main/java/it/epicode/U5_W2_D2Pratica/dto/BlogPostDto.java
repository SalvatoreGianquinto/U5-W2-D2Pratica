package it.epicode.U5_W2_D2Pratica.dto;

import lombok.Data;

@Data
public class BlogPostDto {
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private int autoreId;
}
