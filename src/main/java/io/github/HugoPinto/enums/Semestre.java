package io.github.HugoPinto.enums;

public enum Semestre {
    PRIMEIRO,
    SEGUNDO;

    public int getNumero(){
        return ordinal() + 1;
    }

    public String getDescricao() {
        return this == PRIMEIRO ? "1º semestre" : "2º semestre";
    }
}
