package io.github.HugoPinto.model.turmamodel;

import io.github.HugoPinto.enums.Semestre;
import io.github.HugoPinto.model.disciplinamodel.DisciplinaModel;
import io.github.HugoPinto.model.professormodel.ProfessorModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;


//Essa model representa uma disciplina que é oferecida em um semestre específico. Por exemplo, redes de computadores, disciplina ofertada semestralmente.
@Data
@Entity
public class TurmaModel{

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String codigo;              // ex: "ADS-2025.1", "MAT-3B-2026", obrigatório e único

    @NotBlank
    private String nome;                // ex: "3º Período - Desenvolvimento Web"

    private LocalDate dataInicio;             // 2025, 2026...
    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    private Semestre semestre;           // 1 ou 2

    // Relacionamentos principais
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorModel professor;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private DisciplinaModel disciplina;

}
