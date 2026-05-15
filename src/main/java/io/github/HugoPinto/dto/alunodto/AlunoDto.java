package io.github.HugoPinto.dto.alunodto;

import io.github.HugoPinto.dto.TurmaResumoDto;
import io.github.HugoPinto.model.alunomodel.AlunoModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;



/*
Getter e Setter do lombok realiza os gets e sets automaticamente.
All args constructor gera construtor com todos os campos na ordem declarada
 */

@Getter
@Setter
@AllArgsConstructor //Gera um construtor com todos os campos
@NoArgsConstructor  // ← isso gera o construtor vazio public AlunoDto() {}
public class AlunoDto {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email
    private String email;

    @NotBlank(message = "CPF é obrigatório")
    @CPF
    private String cpf;

    @NotBlank
    @Size(min = 8, max = 20)
    private String matricula;

    //Manter String por enquanto, porém, mudar lá na frente para List<CursosDto>
    private String curso;

    private int idade;

    private List<TurmaResumoDto> turmas;

    //construtor que recebe uma model como argumento e instancia o objeto
    //Basicamente, converte o findByiD da model/DAO para o DTO.
    public AlunoDto(AlunoModel aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.cpf = aluno.getCpf();
        this.matricula = aluno.getMatricula();
        this.curso = aluno.getCurso();
        this.idade = aluno.getIdade();

        // Conversão segura da turma
        this.turmas = aluno.getTurmas().stream()
                .map(TurmaResumoDto::new)
                .toList();
    }
}
