package io.github.HugoPinto.dto.disciplinadto;

import io.github.HugoPinto.model.professormodel.ProfessorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DisciplinaDto {
    private long id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    private ProfessorModel professor;
}
