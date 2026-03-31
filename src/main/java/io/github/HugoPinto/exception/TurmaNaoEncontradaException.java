package io.github.HugoPinto.exception;

public class TurmaNaoEncontradaException extends RuntimeException{
    private String mensagem;

    public TurmaNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
