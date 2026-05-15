package io.github.HugoPinto.model.disciplinamodel;

import io.github.HugoPinto.model.professormodel.ProfessorModel;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DisciplinaModel {
    @Id
    @GeneratedValue
    private long id;
    private String nome;                //nome da disciplina
    private String descricao;           //opcional: ementa resumida
    private Integer cargaHoraria;       //em horas

    @ManyToOne
    private ProfessorModel professor;   //Professor responsável pela disciplina.
}
