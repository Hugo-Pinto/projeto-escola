package io.github.HugoPinto.facade.alunofacade;

import io.github.HugoPinto.dao.TurmaDao;
import io.github.HugoPinto.dao.alunodao.AlunoDao;
import io.github.HugoPinto.dto.alunodto.AlunoRequestDto;
import io.github.HugoPinto.dto.alunodto.AlunoResponseDto;
import io.github.HugoPinto.exception.AlunoNaoEncontradoException;
import io.github.HugoPinto.mapper.AlunoMapper;
import io.github.HugoPinto.model.alunomodel.AlunoModel;
import io.github.HugoPinto.model.turmamodel.TurmaModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
@ApplicationScoped
public class AtualizarAlunoFacade {

    @Inject
    AlunoDao alunoDao;

    @Inject
    AlunoMapper alunoMapper;

    @Inject
    TurmaDao turmaDao;

    public AlunoResponseDto executar(long id, AlunoRequestDto aluno){
        return atualizarAluno(id, aluno);
    }

    private AlunoResponseDto atualizarAluno(long id, AlunoRequestDto aluno) {
        AlunoModel alunoModel = alunoDao.findById(id);

        if (alunoModel == null) {
            throw new AlunoNaoEncontradoException(id);
        }

        alunoMapper.updateModelFromDto(aluno, alunoModel);

        if (aluno.getTurmas() != null) {
            Set<TurmaModel> turmas = turmaDao.listByIds(aluno.getTurmas());
            alunoModel.setTurmas(turmas);
        }

        alunoDao.persist(alunoModel); // ou nem precisa, dependendo da transação
        log.info("Objeto aluno: {} foi atualizado com sucesso!", alunoModel);

        return alunoMapper.toResponseDto(alunoModel);
    }
}

