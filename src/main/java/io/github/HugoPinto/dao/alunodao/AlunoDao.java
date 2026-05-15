package io.github.HugoPinto.dao.alunodao;

import io.github.HugoPinto.model.alunomodel.AlunoModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlunoDao implements PanacheRepository<AlunoModel> {
}
