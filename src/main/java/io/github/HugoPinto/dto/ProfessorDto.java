package io.github.HugoPinto.dto;
import io.github.HugoPinto.model.ProfessorModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;


@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProfessorDto {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank
    private String email;

    @CPF
    @NotBlank(message = "CPF inválido")
    private String cpf;

    @NotBlank
    @Size(min = 8, max = 20)
    private String matricula;

    private LocalDate dataNascimento; //Formatar a data manualmente para obrigar um .ofPattern definido por mim

    private String titulacao;

    private String areaAtuacao;

    private boolean ativo = true;

    //private List<TurmaResumoDto> turmas;
    private List<Long> turmas;

    //private List<DisciplinaResumoDto> disciplinas;
    private List<String> disciplinas;

    //Desta forma, instanciamos um objeto ProfessorDTO passando argumentos de um objeto ProfessorModel
    public ProfessorDto(ProfessorModel professorModel){
        this(
                professorModel.getId(),
                professorModel.getNome(),
                professorModel.getEmail(),
                professorModel.getCpf(),
                professorModel.getMatricula(),
                professorModel.getDataNascimento(),
                professorModel.getTitulacao(),
                professorModel.getAreaAtuacao(),
                professorModel.isAtivo(),
                professorModel.getTurmas(),
                professorModel.getDisciplinas());
    }
}
