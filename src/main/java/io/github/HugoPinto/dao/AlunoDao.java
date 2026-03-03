package io.github.HugoPinto.dao;

import io.github.HugoPinto.dto.AlunoDto;
import io.github.HugoPinto.model.AlunoModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlunoDao implements PanacheRepository<AlunoModel> {

}
