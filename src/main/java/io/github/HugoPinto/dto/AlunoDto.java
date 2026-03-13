package io.github.HugoPinto.dto;

import io.github.HugoPinto.model.AlunoModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;



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

    //construtor que recebe uma model como argumento e instancia o objeto
    //Basicamente, converte o findByiD da model/DAO para o DTO.
    public AlunoDto(AlunoModel aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf(), aluno.getMatricula(), aluno.getCurso(), aluno.getIdade());
    }
}
