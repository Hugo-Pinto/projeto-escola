package io.github.HugoPinto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class ProfessorModel {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String matricula;
    private LocalDate dataNascimento;
    private String titulacao;
    private String areaAtuacao;
    private boolean ativo = true;
    private List<Long> turmas;
    private List<String> disciplinas;
}
