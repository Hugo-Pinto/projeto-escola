package io.github.HugoPinto.dto;

import io.github.HugoPinto.enums.Semestre;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TurmaDto {

    private Long id;

    private String codigo;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Data é obrigatório")
    private LocalDate data;

    @NotBlank(message = "Semestre é obrigatório")
    private Semestre semestre;

//    private ProfessorDto professor;

}
