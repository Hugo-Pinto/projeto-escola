package io.github.HugoPinto.model.matriculamodel;


import io.github.HugoPinto.enums.Semestre;
import io.github.HugoPinto.model.turmamodel.TurmaModel;
import io.github.HugoPinto.model.alunomodel.AlunoModel;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class MatriculaModel {

    //Entidade associativa utilizada para unir aluno com turma
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoModel aluno;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private TurmaModel turma;

    private double nota;
    private Integer frequencia;
    private LocalDate dataMatricula;

    private Semestre status;
}
