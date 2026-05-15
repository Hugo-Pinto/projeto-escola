package io.github.HugoPinto.dto;


import io.github.HugoPinto.enums.Semestre;
import io.github.HugoPinto.model.turmamodel.TurmaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurmaResumoDto {

    private Long id;
    private String codigo;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Semestre semestre;
    private String professor;
    private String disciplina;

    // Construtor de conversão
    public TurmaResumoDto(TurmaModel turma) {
        this.id = turma.getId();
        this.codigo = turma.getCodigo();
        this.nome = turma.getNome();
        this.dataInicio = turma.getDataInicio();
        this.dataFim = turma.getDataFim();
        this.semestre = turma.getSemestre();

        this.professor = turma.getProfessor() != null ? turma.getProfessor().getNome() : null;
        this.disciplina = turma.getDisciplina() != null ? turma.getDisciplina().getNome() : null;
    }
}
