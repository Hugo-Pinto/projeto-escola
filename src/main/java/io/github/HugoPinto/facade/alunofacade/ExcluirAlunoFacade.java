package io.github.HugoPinto.facade.alunofacade;

import io.github.HugoPinto.dao.alunodao.AlunoDao;
import io.github.HugoPinto.dto.alunodto.AlunoRequestDto;
import io.github.HugoPinto.dto.alunodto.AlunoResponseDto;
import io.github.HugoPinto.exception.AlunoNaoEncontradoException;
import io.github.HugoPinto.mapper.AlunoMapper;
import io.github.HugoPinto.model.alunomodel.AlunoModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class ExcluirAlunoFacade {

    @Inject
    AlunoDao alunoDao;

    @Inject
    AlunoMapper alunoMapper;

    @Transactional
    public AlunoResponseDto executar(long id){
        return excluirAluno(id);
    }

    private AlunoResponseDto excluirAluno(long id){
        AlunoModel aluno = alunoDao.findById(id);

        if(aluno != null){
            alunoDao.delete(aluno);
            log.info("Aluno excluído: {}", aluno);
            return alunoMapper.toResponseDto(aluno);
        }
        throw new AlunoNaoEncontradoException(id);
    }
}
