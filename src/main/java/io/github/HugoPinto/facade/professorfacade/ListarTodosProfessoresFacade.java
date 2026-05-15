package io.github.HugoPinto.facade.professorfacade;

import io.github.HugoPinto.dao.professordao.ProfessorDao;
import io.github.HugoPinto.dto.professordto.ProfessorDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@ApplicationScoped
public class ListarTodosProfessoresFacade {

    @Inject
    ProfessorDao professorDao;

    public List<ProfessorDto> executar(){

        log.info("O objeto professor nao pode ser vazio!");

        return professorDao.listAll()
                .stream()
                .map(ProfessorDto::new)
                .toList();
    }
}
