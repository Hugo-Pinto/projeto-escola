package io.github.HugoPinto.facade.alunofacade;

import io.github.HugoPinto.dao.TurmaDao;
import io.github.HugoPinto.dao.alunodao.AlunoDao;
import io.github.HugoPinto.dto.alunodto.AlunoRequestDto;
import io.github.HugoPinto.dto.alunodto.AlunoResponseDto;
import io.github.HugoPinto.mapper.AlunoMapper;
import io.github.HugoPinto.model.alunomodel.AlunoModel;
import io.github.HugoPinto.model.turmamodel.TurmaModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
@ApplicationScoped
public class CriarAlunoFacade {

    @Inject
    AlunoMapper alunoMapper;

    @Inject
    AlunoDao alunoDao;

    @Inject
    TurmaDao turmaDao;

    @Transactional
    public AlunoResponseDto executar(AlunoRequestDto aluno) {
        return executar(aluno);
    }

    private AlunoResponseDto criarAluno(AlunoRequestDto aluno){

        //Faz uso do mapper para mapear o DTO e criar a entidade.
        AlunoModel alunoModel = alunoMapper.toModel(aluno);

        if (aluno.getTurmas() != null && !aluno.getTurmas().isEmpty()) {
            Set<TurmaModel> turmas = turmaDao.listByIds(aluno.getTurmas());
            alunoModel.setTurmas(turmas);
        }

        //Armazena na DAO, a model do aluno criado
        alunoDao.persist(alunoModel);

        log.info("Aluno cadastrado com sucesso no sistema: {}", alunoModel);

        return alunoMapper.toResponseDto(alunoModel);
    }
}
