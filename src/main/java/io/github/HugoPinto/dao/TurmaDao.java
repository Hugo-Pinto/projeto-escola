package io.github.HugoPinto.dao;

import io.github.HugoPinto.model.TurmaModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TurmaDao implements PanacheRepository<TurmaModel> {
}
