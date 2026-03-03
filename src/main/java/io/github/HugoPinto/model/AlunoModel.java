package io.github.HugoPinto.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class AlunoModel{
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private int idade;
    private String curso;
}
