package io.github.HugoPinto.dao.professordao;

import io.github.HugoPinto.model.professormodel.ProfessorModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProfessorDao implements PanacheRepository<ProfessorModel>{
}
