package io.github.HugoPinto.model.professormodel;

import io.github.HugoPinto.model.turmamodel.TurmaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class ProfessorModel {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    @Email
    private String email;

    @CPF
    private String cpf;

    @Column(unique = true)
    private String matricula;

    private LocalDate dataNascimento;
    private String titulacao;
    private String areaAtuacao;
    private boolean ativo = true;

    @OneToMany(mappedBy = "professor")
    private Set<TurmaModel> turmas = new HashSet<>();

}
