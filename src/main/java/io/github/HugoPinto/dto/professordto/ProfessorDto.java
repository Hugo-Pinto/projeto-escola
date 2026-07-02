package io.github.HugoPinto.dto.professordto;

import io.github.HugoPinto.dto.TurmaResumoDto;
import io.github.HugoPinto.model.professormodel.ProfessorModel;
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

    private LocalDate dataNascimento;

    private String titulacao;

    private String areaAtuacao;

    private boolean ativo = true;

    private List<TurmaResumoDto> turmas;

    public ProfessorDto(ProfessorModel professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.email = professor.getEmail();
        this.cpf = professor.getCpf();
        this.matricula = professor.getMatricula();
        this.dataNascimento = professor.getDataNascimento();
        this.titulacao = professor.getTitulacao();
        this.areaAtuacao = professor.getAreaAtuacao();
        this.ativo = professor.isAtivo();

        this.turmas = professor.getTurmas().stream()
                .map(TurmaResumoDto::new)
                .toList();
    }
}
