package io.github.HugoPinto.model.alunomodel;

import io.github.HugoPinto.model.turmamodel.TurmaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class AlunoModel{

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
    private int idade;
    private String curso;

    @ManyToMany
    @JoinTable(
            name = "matricula",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "turma_id")
    )
    private Set<TurmaModel> turmas = new HashSet<>();

}
