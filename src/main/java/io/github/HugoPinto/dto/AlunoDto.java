package io.github.HugoPinto.dto;

import io.github.HugoPinto.model.AlunoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



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
    private String nome;
    private int idade;
    private String curso;

    //construtor que recebe uma model como argumento e instancia o objeto
    public AlunoDto(AlunoModel aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getIdade(), aluno.getCurso());
    }
}
