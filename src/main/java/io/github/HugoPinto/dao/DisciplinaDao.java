package io.github.HugoPinto.dao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import io.github.HugoPinto.model.disciplinamodel.DisciplinaModel;

@ApplicationScoped
public class DisciplinaDao implements PanacheRepository<DisciplinaModel>{
}
