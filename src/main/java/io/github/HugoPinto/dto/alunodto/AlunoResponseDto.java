package io.github.HugoPinto.dto.alunodto;

import io.github.HugoPinto.dto.TurmaResumoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoResponseDto {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String matricula;
    private String curso;
    private int idade;

    private List<TurmaResumoDto> turmas;
}
