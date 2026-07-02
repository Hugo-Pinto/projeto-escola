package io.github.HugoPinto.facade.alunofacade;

import io.github.HugoPinto.dao.alunodao.AlunoDao;
import io.github.HugoPinto.dto.alunodto.AlunoRequestDto;
import io.github.HugoPinto.dto.alunodto.AlunoResponseDto;
import io.github.HugoPinto.exception.AlunoNaoEncontradoException;
import io.github.HugoPinto.mapper.AlunoMapper;
import io.github.HugoPinto.model.alunomodel.AlunoModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class ListarAlunoFacade {

    @Inject
    AlunoDao alunoDao;

    @Inject
    AlunoMapper alunoMapper;

    public AlunoResponseDto executar(long id){
        return listarAluno(id);
    }

    private AlunoResponseDto listarAluno(long id){
        final AlunoModel aluno = alunoDao.findById(id);

        if(aluno!= null){
            return alunoMapper.toResponseDto(aluno);
        }
        throw new AlunoNaoEncontradoException(id);
    }

}
