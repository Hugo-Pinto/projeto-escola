package io.github.HugoPinto.exception;

import jakarta.ws.rs.ext.Provider;

@Provider
public class AlunoNaoEncontradoException extends RuntimeException{

    private final Long alunoId;

    public AlunoNaoEncontradoException(Long alunoId, String mensagem){
        super(mensagem);
        this.alunoId = alunoId;
    }

    public AlunoNaoEncontradoException(Long alunoId){
        super("Usuário com ID " + alunoId + " não encontrado");
        this.alunoId = alunoId;
    }
}
