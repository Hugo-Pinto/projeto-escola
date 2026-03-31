package io.github.HugoPinto.model;

import io.github.HugoPinto.dto.ProfessorDto;
import io.github.HugoPinto.enums.Semestre;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class TurmaModel{
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String codigo;              // ex: "ADS-2025.1", "MAT-3B-2026", obrigatório e único

    @NotBlank
    private String nome;                // ex: "3º Período - Desenvolvimento Web"

    private LocalDate data;                // 2025, 2026...

    @Enumerated(EnumType.STRING)
    private Semestre semestre;           // 1 ou 2


    // Relacionamentos principais
//    @ManyToOne
//    @JoinColumn(name = "professor_id")
//        private ProfessorDto professor;

//    @ManyToOne
//    @JoinColumn(name = "disciplina_id")
//    private Disciplina disciplina;      // Disciplina que está sendo cursada nessa turma

}
