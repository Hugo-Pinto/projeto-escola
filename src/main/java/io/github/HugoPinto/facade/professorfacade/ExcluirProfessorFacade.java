package io.github.HugoPinto.facade.professorfacade;

import io.github.HugoPinto.dao.professordao.ProfessorDao;
import io.github.HugoPinto.dto.professordto.ProfessorDto;
import io.github.HugoPinto.exception.professorexception.ProfessorNaoEncontradoException;
import io.github.HugoPinto.model.professormodel.ProfessorModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class ExcluirProfessorFacade {

    @Inject
    ProfessorDao professorDao;

    @Transactional
    public ProfessorDto executar(Long id) {
        validarProfessor(id);
        return excluirProfessor(id);
    }

    private void validarProfessor(Long id){
            if (id == null) {
                throw new IllegalArgumentException(
                        "Id não pode ser nulo"
                );
            }
    }

    private ProfessorDto excluirProfessor(Long id){

        ProfessorModel professorModel = professorDao
                .findByIdOptional(id)
                .orElseThrow(() ->
                        new ProfessorNaoEncontradoException(
                                "Professor de id: " + id + " nao foi encontrado!"
                        ));

        ProfessorDto retorno = new ProfessorDto(professorModel);

        professorDao.delete(professorModel);

        return retorno;
    }
}
