package io.github.HugoPinto.enums;

public enum Situacao {
    APROVADO,
    REPROVADO,
    CURSANDO,
    TRANCADO;

    public int getNumero(){
        return ordinal() + 1;
    }
}
