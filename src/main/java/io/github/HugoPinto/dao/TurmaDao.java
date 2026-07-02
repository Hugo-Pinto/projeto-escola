package io.github.HugoPinto.dao;

import io.github.HugoPinto.model.turmamodel.TurmaModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class TurmaDao implements PanacheRepository<TurmaModel> {

    /**
     * Busca várias turmas por lista de IDs e retorna como Set
     */
    public Set<TurmaModel> listByIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return Set.of(); // retorna Set vazio
        }

        List<TurmaModel> turmas = list("id in ?1", ids);
        return new HashSet<>(turmas);
    }

    // Metodo opcional: caso queira buscar uma única turma
    public TurmaModel findById(Long id) {
        return findByIdOptional(id).orElse(null);
    }
}