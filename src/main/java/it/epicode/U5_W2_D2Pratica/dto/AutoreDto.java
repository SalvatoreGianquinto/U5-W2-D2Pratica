package it.epicode.U5_W2_D2Pratica.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDto {
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
}
