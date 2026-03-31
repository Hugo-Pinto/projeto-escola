package io.github.HugoPinto.facade;


import io.github.HugoPinto.dao.TurmaDao;
import io.github.HugoPinto.dto.TurmaDto;
import io.github.HugoPinto.exception.TurmaNaoEncontradaException;
import io.github.HugoPinto.model.TurmaModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class TurmaFacade {

    @Inject
    TurmaDao turmaDao;

    @Transactional
    public TurmaDto cadastrarTurma(TurmaDto turmaDto){
        if(turmaDto != null){
            var turma = new TurmaModel();

            log.info("Cadastrando turma na base de dados!");

            turma.setCodigo(turmaDto.getCodigo());
            turma.setData(turmaDto.getData());
            turma.setNome(turmaDto.getNome());
            turma.setSemestre(turmaDto.getSemestre());
            //turma.setProfessor(turmaDto.getProfessor());

            turmaDao.persist(turma);

            turmaDto.setId(turma.getId());

            log.info("Turma de ID {} cadastrado com sucesso!", turma.getId());

            return turmaDto;

        }
        else {
            throw new RuntimeException("Os dados de cadastro da turma estão incorretos!");
        }
    }
}
