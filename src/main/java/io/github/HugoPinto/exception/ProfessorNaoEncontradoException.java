package io.github.HugoPinto.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProfessorNaoEncontradoException extends RuntimeException{

    private String mensagem;
    private Long id;

    public ProfessorNaoEncontradoException(String mensagem, Long id){
        super(mensagem);
        this.id = id;
    }

    public ProfessorNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
